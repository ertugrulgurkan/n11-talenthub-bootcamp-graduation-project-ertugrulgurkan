package com.ertugrul.credit.service;

import com.ertugrul.credit.dto.UserRequestDto;
import com.ertugrul.credit.dto.UserResponseDto;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.mapper.UserMapper;
import com.ertugrul.credit.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;
    private final ValidationService validationService;

    public List<UserResponseDto> findAll() {

        List<User> userList = userEntityService.findAll();

        return UserMapper.INSTANCE.convertAllUserToUserResponseDto(userList);
    }

    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {

        User user = UserMapper.INSTANCE.convertUserRequestDtoToUser(userRequestDto);
        //todo calculate CreditScore

        User savedUser = userEntityService.save(user);
        return UserMapper.INSTANCE.convertUserResponseDtoToUser(savedUser);
    }

    public UserResponseDto findById(Long id) {
        User userById = findUserById(id);
        return UserMapper.INSTANCE.convertUserResponseDtoToUser(userById);
    }

    public UserResponseDto findByNationalIdNumber(String nationalIdNumber) {
        User userByNationalIdNumber = findUserByNationalIdNumber(nationalIdNumber);
        return UserMapper.INSTANCE.convertUserResponseDtoToUser(userByNationalIdNumber);
    }

    @Transactional
    public void deleteById(Long id) {
        User user = findUserById(id);
        userEntityService.delete(user);
    }

    @Transactional
    public void deleteByNationalIdNumber(String nationalIdNumber) {
        User user = findUserByNationalIdNumber(nationalIdNumber);
        userEntityService.delete(user);
    }

    private User findUserById(Long id) {
        Optional<User> optionalUser = userEntityService.findById(id);
        return validationService.validateUser(optionalUser);
    }

    private User findUserByNationalIdNumber(String nationalIdNumber) {
        Optional<User> optionalUser = userEntityService.findByNationalIdNumber(nationalIdNumber);
        return validationService.validateUser(optionalUser);
    }
}
