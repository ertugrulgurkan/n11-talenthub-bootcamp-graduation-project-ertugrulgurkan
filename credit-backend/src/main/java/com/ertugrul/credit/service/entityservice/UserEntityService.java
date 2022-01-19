package com.ertugrul.credit.service.entityservice;


import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserEntityService extends BaseEntityService<User, UserRepository> {
    public UserEntityService(UserRepository userRepository) {
        super(userRepository);
    }

    public Optional<User> findByNationalIdNumber(String nationalIdNumber) {
        return getRepository().findByNationalIdNumber(nationalIdNumber);
    }
}