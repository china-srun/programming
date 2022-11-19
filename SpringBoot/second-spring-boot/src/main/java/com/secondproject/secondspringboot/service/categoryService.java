package com.secondproject.secondspringboot.service;

import java.util.List;

import com.secondproject.secondspringboot.dataTransferObject.categoryDto;
import com.secondproject.secondspringboot.model.category;

public interface categoryService extends BaseService<categoryDto, List<categoryDto>, String, category > {
    
}
