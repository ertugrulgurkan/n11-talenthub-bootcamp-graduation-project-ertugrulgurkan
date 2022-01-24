package com.ertugrul.credit.mapper;

import com.ertugrul.credit.dto.UserRequestDto;
import com.ertugrul.credit.dto.UserResponseDto;
import com.ertugrul.credit.dto.UserUpdateRequestDto;
import com.ertugrul.credit.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRequestDto convertUserRequestDtoToUser(User user);

    UserUpdateRequestDto convertUserToUserToUserUpdateRequestDto(User user);

    User convertUserRequestDtoToUser(UserRequestDto UserRequestDto);

    User convertUserUpdateRequestDtoToUser(UserUpdateRequestDto UserUpdateRequestDto);

    @Mapping(target = "monthlyIncome", source = "creditApplication.monthlyIncome")
    UserResponseDto convertUserResponseDtoToUser(User user);

    @Mapping(source = "monthlyIncome", target = "creditApplication.monthlyIncome")
    User convertUserResponseDtoToUser(UserResponseDto UserResponseDto);

    List<UserRequestDto> convertAllUserRequestDtoToUser(List<User> userList);

    List<User> convertAllUserToUserRequestDto(List<UserRequestDto> userRequestDtoList);

    @Mapping(source = "monthlyIncome", target = "creditApplication.monthlyIncome")
    List<User> convertAllUserResponseDtoToUser(List<UserResponseDto> userList);

    @Mapping(target = "monthlyIncome", source = "creditApplication.monthlyIncome")
    List<UserResponseDto> convertAllUserToUserResponseDto(List<User> UserResponseDtoList);
}