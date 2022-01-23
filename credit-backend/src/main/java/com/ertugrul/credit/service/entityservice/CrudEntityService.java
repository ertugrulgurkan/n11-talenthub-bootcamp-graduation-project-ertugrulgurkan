package com.ertugrul.credit.service.entityservice;

import java.util.List;
import java.util.Optional;

public interface CrudEntityService<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}