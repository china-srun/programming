package com.tgisecurity.tgitest.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tgisecurity.tgitest.model.Privilege;
import com.tgisecurity.tgitest.model.Role;
import com.tgisecurity.tgitest.model.RolePrivilege;
import com.tgisecurity.tgitest.model.User;
import com.tgisecurity.tgitest.model.UserRole;
import com.tgisecurity.tgitest.repository.PrivilegeRepository;
import com.tgisecurity.tgitest.repository.RolePrivilegeRepository;
import com.tgisecurity.tgitest.repository.RoleRepository;
import com.tgisecurity.tgitest.repository.UserRepository;
import com.tgisecurity.tgitest.repository.UserRoleRepository;

@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        final Optional<User> accountByUsername = userRepository.findByUserName(username.toUpperCase());
        if (accountByUsername.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + "not found");
        }

        Collection<Role> roles = new ArrayList<>();

        UserRole userrole = userRoleRepository.findByUserId(accountByUsername.get().getId());
        Role roleFromRepo = roleRepository.findById(userrole.getRoleId()).get();

        roles.add(roleFromRepo);


        return new org.springframework.security.core.userdetails.User(accountByUsername.get().getUserName().toUpperCase(), accountByUsername.get().getPassword(),
                true, true, true, true,
                getAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<Privilege> collection = new ArrayList<>();
        for (final Role role : roles) {
            List<RolePrivilege> rolePrivileges = rolePrivilegeRepository.findAllByRoleId(role.getId());
            rolePrivileges.forEach(r -> {
                Privilege privilege = privilegeRepository.findById(r.getId()).get();
                collection.add(privilege);
            });

        }
        for (final Privilege privilege : collection) {
            privileges.add(privilege.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
