package com.ertugrul.credit.service.entityservice.impl;


import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.repository.UserRepository;
import com.ertugrul.credit.service.entityservice.UserEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserEntityServiceImpl extends BaseEntityService<User, UserRepository> implements UserEntityService {

    public UserEntityServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Optional<User> findByNationalIdNumber(String nationalIdNumber) {
        return getRepository().findByNationalIdNumber(nationalIdNumber);
    }
}