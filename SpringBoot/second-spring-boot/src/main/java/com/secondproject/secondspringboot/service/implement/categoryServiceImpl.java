package com.secondproject.secondspringboot.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.secondproject.secondspringboot.dataTransferObject.categoryDto;
import com.secondproject.secondspringboot.model.category;
import com.secondproject.secondspringboot.repository.categoryRepository;
import com.secondproject.secondspringboot.service.categoryService;

@Service
public class categoryServiceImpl extends baseServiceImpl<categoryDto, List<categoryDto>, String, category> implements categoryService{

    @Autowired 
    private categoryRepository CategoryRepository;

    @Override
    protected JpaRepository<category, String> getBaseRepository() {
        return CategoryRepository;
    }

    @Override
    protected categoryDto newResponse() {
        return new categoryDto();
    }
    
}
