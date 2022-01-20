package com.ertugrul.credit.service.entityservice;

import com.ertugrul.credit.entity.BaseEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository> {
    private R repository;

    public List<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E save(E e) {
        return (E) repository.save(e);
    }

    public void delete(E e) {
        repository.delete(e);
    }

    public R getRepository() {
        return repository;
    }
}
