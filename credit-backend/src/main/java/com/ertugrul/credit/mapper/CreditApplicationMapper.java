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

    @Mapping(target = "nationalIdNumber", source = "user.nationalIdNumber")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "birthDate", source = "user.birthDate")
    CreditApplicationRequestDto convertCreditApplicationToCreditApplicationRequestDto(CreditApplication creditApplication);

    @Mapping(source = "nationalIdNumber", target = "user.nationalIdNumber")
    @Mapping(source = "name", target = "user.name")
    @Mapping(source = "surname", target = "user.surname")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "birthDate", target = "user.birthDate")
    CreditApplication convertCreditApplicationRequestDtoToCreditApplication(CreditApplicationRequestDto CreditApplicationRequestDto);

    @Mapping(target = "nationalIdNumber", source = "user.nationalIdNumber")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "birthDate", source = "user.birthDate")
    CreditApplicationResponseDto convertCreditApplicationResponseDtoToCreditApplication(CreditApplication creditApplication);

    @Mapping(source = "nationalIdNumber", target = "user.nationalIdNumber")
    @Mapping(source = "name", target = "user.name")
    @Mapping(source = "surname", target = "user.surname")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "birthDate", target = "user.birthDate")
    CreditApplication convertCreditApplicationResponseDtoToCreditApplication(CreditApplicationResponseDto CreditApplicationResponseDto);

    @Mapping(target = "userNationalIdNumber", source = "user.nationalIdNumber")
    List<CreditApplicationRequestDto> convertAllCreditApplicationRequestDtoToCreditApplication(List<CreditApplication> creditApplicationList);

    @Mapping(source = "userNationalIdNumber", target = "user.nationalIdNumber")
    List<CreditApplication> convertAllCreditApplicationToCreditApplicationRequestDto(List<CreditApplicationRequestDto> creditApplicationRequestDtoList);

    @Mapping(target = "nationalIdNumber", source = "user.nationalIdNumber")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "birthDate", source = "user.birthDate")
    List<CreditApplication> convertAllCreditApplicationResponseDtoToCreditApplication(List<CreditApplicationResponseDto> creditApplicationList);

    @Mapping(source = "nationalIdNumber", target = "user.nationalIdNumber")
    @Mapping(source = "name", target = "user.name")
    @Mapping(source = "surname", target = "user.surname")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "birthDate", target = "user.birthDate")
    List<CreditApplicationResponseDto> convertAllCreditApplicationToCreditApplicationResponseDto(List<CreditApplication> CreditApplication);

    @Mapping(target = "nationalIdNumber", source = "user.nationalIdNumber")
    CreditApplicationResultDto convertCreditApplicationToCreditApplicationResultDto(CreditApplication creditApplication);

    @Mapping(target = "nationalIdNumber", source = "user.nationalIdNumber")
    List<CreditApplicationResultDto> convertAllCreditApplicationToCreditApplicationResultDto(List<CreditApplication> creditApplicationList);

    @Mapping(source = "nationalIdNumber", target = "user.nationalIdNumber")
    CreditApplication convertCreditApplicationResultDtoToCreditApplication(CreditApplicationResultDto creditApplicationResultDto);
}