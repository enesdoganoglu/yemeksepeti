package com.bilgeadam.service;

import com.bilgeadam.dto.request.customer.ActivateRequestDto;

import com.bilgeadam.dto.request.customer.CustomerUpdateRequestDto;
import com.bilgeadam.dto.request.customer.LoginRequestDto;
import com.bilgeadam.dto.request.customer.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.exception.CustomerManagerException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.ICustomerMapper;
import com.bilgeadam.repository.ICustomerRepository;
import com.bilgeadam.repository.entity.Customer;
import com.bilgeadam.repository.entity.Order;
import com.bilgeadam.repository.entity.enums.EStatus;
import com.bilgeadam.utility.CodeGenerator;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final ICustomerRepository repository;


    public CustomerService(ICustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public RegisterResponseDto register(RegisterRequestDto dto){
        Customer customer = ICustomerMapper.INSTANCE.fromRequestDtoToCustomer(dto);
        if (dto.getPassword().equals(dto.getRepassword())){
            customer.setActivationCodeLogin(CodeGenerator.generateCode());
            save(customer);
        }else {
            throw new CustomerManagerException(ErrorType.PASSWORD_ERROR);
        }
        RegisterResponseDto responseDto = ICustomerMapper.INSTANCE.fromCustomerToResponseDto(customer);
        return responseDto;
    }

    public Boolean activateStatus(ActivateRequestDto dto){
        Optional<Customer> customer = findById(dto.getId());
        if (customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.CUSTOMER_NOT_FOUND);
        }else if (customer.get().getActivationCodeLogin().equals(dto.getActivationCodeLogin())) {
            customer.get().setStatus(EStatus.ACTIVE);
            update(customer.get());
            return true;
        }
        throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
    }

    public String login(LoginRequestDto dto){
        Optional<Customer> customer = repository.findByCustomerNameAndPassword(dto.getCustomerName(), dto.getPassword());
        if (customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.LOGIN_ERROR);
        } else if (!customer.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
        return "Giriş başarılı";
    }

    public Customer updateCustomer(CustomerUpdateRequestDto dto){
        Optional<Customer> customer = repository.findById(dto.getId());
        if (customer.isEmpty()){
            throw new CustomerManagerException(ErrorType.CUSTOMER_NOT_FOUND);
        }
        ICustomerMapper.INSTANCE.updateCustomerFromDto(dto, customer.get());
        return repository.save(customer.get());
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }
}
