package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.dto.UserResponseDto;
import com.ertugrul.credit.dto.UserUpdateRequestDto;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.mapper.UserMapper;
import com.ertugrul.credit.service.UserService;
import com.ertugrul.credit.service.ValidationService;
import com.ertugrul.credit.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserEntityService userEntityService;
    private final ValidationService validationService;

    @Override
    public List<UserResponseDto> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertAllUserToUserResponseDto(userList);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public User saveUserToEntity(User user) {
        Optional<User> userOptional = userEntityService.findByNationalIdNumber(user.getNationalIdNumber());
        validationService.validateUserNotExist(userOptional);
        validationService.validateNationalIdNumber(user.getNationalIdNumber());
        return userEntityService.save(user);
    }

    @Transactional
    @Override
    public UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto, String nationalIdNumber) {
        User userRequestEntity = UserMapper.INSTANCE.convertUserUpdateRequestDtoToUser(userUpdateRequestDto);
        User user = findUserByNationalIdNumber(nationalIdNumber);
        fillUserProperties(userRequestEntity, user);
        User updatedUser = userEntityService.save(user);
        return UserMapper.INSTANCE.convertUserToUserResponseDto(updatedUser);
    }

    @Override
    public UserResponseDto findByNationalIdNumber(String nationalIdNumber) {
        User userByNationalIdNumber = findUserByNationalIdNumber(nationalIdNumber);
        return UserMapper.INSTANCE.convertUserToUserResponseDto(userByNationalIdNumber);
    }

    @Transactional
    @Override
    public void deleteByNationalIdNumber(String nationalIdNumber) {
        User user = findUserByNationalIdNumber(nationalIdNumber);
        userEntityService.delete(user);
    }

    @Override
    public User findUserByNationalIdNumber(String nationalIdNumber) {
        Optional<User> optionalUser = userEntityService.findByNationalIdNumber(nationalIdNumber);
        return validationService.validateUser(optionalUser);
    }

    private void fillUserProperties(User userRequestEntity, User user) {
        user.setName(userRequestEntity.getName());
        user.setSurname(userRequestEntity.getSurname());
        user.setBirthDate(userRequestEntity.getBirthDate());
        user.setPhone(userRequestEntity.getPhone());
    }
}
