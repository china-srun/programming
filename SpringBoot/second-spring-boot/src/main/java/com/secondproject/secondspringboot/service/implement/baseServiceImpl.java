package com.secondproject.secondspringboot.service.implement;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.secondproject.secondspringboot.service.BaseService;


@Service
public abstract class baseServiceImpl<DResponse, DResponseList, TKey extends Serializable, TEntity> implements BaseService<DResponse, DResponseList, TKey, TEntity>{

    protected abstract JpaRepository<TEntity, TKey> getBaseRepository();
    protected abstract DResponse newResponse();

    @Override
    public DResponseList getAll() {
        
        return null;
    }
    
    @Override
    public TEntity getById(TKey id) {
        Optional<TEntity> optionalResult = getBaseRepository().findById(id);
        // DResponse response=newResponse();
        if (!optionalResult.isEmpty()) {

        }
        return optionalResult.get();
    }

    @Override
    public DResponse create(TEntity model) {
        return null;
    }

    @Override
    public DResponse update(TKey id, TEntity model) {
        return null;
    }

    @Override
    public DResponse delete(TKey id) {
        return null;
    }
    
}
