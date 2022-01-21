package com.ertugrul.credit.mapper;

import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResponseDto;
import com.ertugrul.credit.dto.CreditApplicationResultDto;
import com.ertugrul.credit.entity.CreditApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditApplicationMapper {
    CreditApplicationMapper INSTANCE = Mappers.getMapper(CreditApplicationMapper.class);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    CreditApplicationRequestDto convertCreditApplicationRequestDtoToCreditApplication(CreditApplication creditApplication);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    CreditApplication convertCreditApplicationRequestDtoToCreditApplication(CreditApplicationRequestDto CreditApplicationRequestDto);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "userSurname", source = "user.surname")
    @Mapping(target = "userPhone", source = "user.phone")
    @Mapping(target = "userBirthDate", source = "user.birthDate")
    CreditApplicationResponseDto convertCreditApplicationResponseDtoToCreditApplication(CreditApplication creditApplication);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    @Mapping(source = "userName", target = "user.name")
    @Mapping(source = "userSurname", target = "user.surname")
    @Mapping(source = "userPhone", target = "user.phone")
    @Mapping(source = "userBirthDate", target = "user.birthDate")
    CreditApplication convertCreditApplicationResponseDtoToCreditApplication(CreditApplicationResponseDto CreditApplicationResponseDto);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    List<CreditApplicationRequestDto> convertAllCreditApplicationRequestDtoToCreditApplication(List<CreditApplication> creditApplicationList);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    List<CreditApplication> convertAllCreditApplicationToCreditApplicationRequestDto(List<CreditApplicationRequestDto> creditApplicationRequestDtoList);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "userSurname", source = "user.surname")
    @Mapping(target = "userPhone", source = "user.phone")
    @Mapping(target = "userBirthDate", source = "user.birthDate")
    List<CreditApplication> convertAllCreditApplicationResponseDtoToCreditApplication(List<CreditApplicationResponseDto> creditApplicationList);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    @Mapping(source = "userName", target = "user.name")
    @Mapping(source = "userSurname", target = "user.surname")
    @Mapping(source = "userPhone", target = "user.phone")
    @Mapping(source = "userBirthDate", target = "user.birthDate")
    List<CreditApplicationResponseDto> convertAllCreditApplicationToCreditApplicationResponseDto(List<CreditApplication> CreditApplication);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    CreditApplicationResultDto convertCreditApplicationToCreditApplicationResultDto(CreditApplication creditApplication);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    List<CreditApplicationResultDto> convertAllCreditApplicationToCreditApplicationResultDto(List<CreditApplication> creditApplicationList);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    CreditApplication convertCreditApplicationResultDtoToCreditApplication(CreditApplicationResultDto creditApplicationResultDto);
}