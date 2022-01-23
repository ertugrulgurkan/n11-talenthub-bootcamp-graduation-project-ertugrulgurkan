package com.ertugrul.credit.service.entityservice;

import com.ertugrul.credit.entity.User;

import java.util.Optional;


public interface UserEntityService extends CrudEntityService<User, Long> {
    Optional<User> findByNationalIdNumber(String nationalIdNumber);
}
