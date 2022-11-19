package com.secondproject.secondspringboot.service;

import java.io.Serializable;
// DResponse = object
// DResponseList = List of object
// TKey = id
// TEntity = dto
public interface BaseService<DResponse, DResponseList, TKey extends Serializable, TEntity>  {
    DResponseList getAll();

    TEntity getById(TKey id);

    DResponse create(TEntity model);

    DResponse update(TKey id, TEntity model);

    DResponse delete(TKey id);
}
