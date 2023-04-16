package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.customer.CustomerUpdateRequestDto;
import com.bilgeadam.dto.request.customer.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.repository.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T22:45:48+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer fromRequestDtoToCustomer(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.customerName( dto.getCustomerName() );
        customer.customerSurname( dto.getCustomerSurname() );
        customer.email( dto.getEmail() );
        customer.password( dto.getPassword() );

        return customer.build();
    }

    @Override
    public RegisterResponseDto fromCustomerToResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.customerName( customer.getCustomerName() );

        return registerResponseDto.build();
    }

    @Override
    public void updateCustomerFromDto(CustomerUpdateRequestDto dto, Customer customer) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCustomerName() != null ) {
            customer.setCustomerName( dto.getCustomerName() );
        }
        if ( dto.getCustomerSurname() != null ) {
            customer.setCustomerSurname( dto.getCustomerSurname() );
        }
        if ( dto.getEmail() != null ) {
            customer.setEmail( dto.getEmail() );
        }
        if ( dto.getAddress() != null ) {
            customer.setAddress( dto.getAddress() );
        }
        if ( dto.getPhoneNumber() != null ) {
            customer.setPhoneNumber( dto.getPhoneNumber() );
        }
        if ( dto.getPassword() != null ) {
            customer.setPassword( dto.getPassword() );
        }
        if ( dto.getCardDetails() != null ) {
            customer.setCardDetails( dto.getCardDetails() );
        }
        if ( dto.getBalance() != null ) {
            customer.setBalance( dto.getBalance() );
        }
    }
}
