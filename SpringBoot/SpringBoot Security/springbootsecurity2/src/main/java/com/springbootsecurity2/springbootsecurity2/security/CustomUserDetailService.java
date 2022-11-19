package com.springbootsecurity2.springbootsecurity2.security;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springbootsecurity2.springbootsecurity2.model.Privilege;
import com.springbootsecurity2.springbootsecurity2.model.Role;
import com.springbootsecurity2.springbootsecurity2.model.RolePrivilege;
import com.springbootsecurity2.springbootsecurity2.model.User;
import com.springbootsecurity2.springbootsecurity2.model.UserRole;
import com.springbootsecurity2.springbootsecurity2.repository.PrivilegeRepository;
import com.springbootsecurity2.springbootsecurity2.repository.RolePrivilegeRepository;
import com.springbootsecurity2.springbootsecurity2.repository.RoleRepository;
import com.springbootsecurity2.springbootsecurity2.repository.UserRepository;
import com.springbootsecurity2.springbootsecurity2.repository.UserRoleRepository;

@Service
// if there are any issues, the system will rollback to its original state
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
        // to know what request we are getting
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // we do this to check whether the username the user log in exists in the database or not
        final Optional<User> accountByUsername = userRepository.findByUserName(username.toUpperCase());
        if (accountByUsername.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + "not found!" );
        } 

        Collection<Role> roles = new ArrayList<>();
        UserRole userRole = userRoleRepository.findByUserId(accountByUsername.get().getId());
        Role roleFromRepo = roleRepository.findById(userRole.getRoleId()).get();

        roles.add(roleFromRepo);
        // true, true, true, true = enabled, accountNonExpired, credentialNonExpired, accountNonLocked
        return new org.springframework.security.core.userdetails.User(accountByUsername.get().getUserName().toUpperCase(), 
                        accountByUsername.get().getPassword().toLowerCase(), true, true, true, true, getAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<Privilege> collection = new ArrayList<>();
        
        for (final Role role: roles) {
            List<RolePrivilege> rolePrivilege = rolePrivilegeRepository.findAllByRoleId(role.getId());
            rolePrivilege.forEach(r -> {
                Privilege privilege = privilegeRepository.findById(r.getId()).get();
                collection.add(privilege);
            });
        }
        for (final Privilege privilege: collection) {
            privileges.add(privilege.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (final String privilege: privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    
}
