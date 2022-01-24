package com.ertugrul.credit.service;

import com.ertugrul.credit.dto.UserResponseDto;
import com.ertugrul.credit.dto.UserUpdateRequestDto;
import com.ertugrul.credit.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();

    User saveUserToEntity(User user);

    UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto, String nationalIdNumber);

    UserResponseDto findByNationalIdNumber(String nationalIdNumber);

    void deleteByNationalIdNumber(String nationalIdNumber);

    User findUserByNationalIdNumber(String nationalIdNumber);

}
