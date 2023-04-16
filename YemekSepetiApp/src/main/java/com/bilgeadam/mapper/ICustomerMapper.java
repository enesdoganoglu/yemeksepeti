package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.customer.CustomerUpdateRequestDto;
import com.bilgeadam.dto.request.customer.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.repository.entity.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICustomerMapper {
    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer fromRequestDtoToCustomer(RegisterRequestDto dto);

    RegisterResponseDto fromCustomerToResponseDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CustomerUpdateRequestDto dto, @MappingTarget Customer customer);
}
