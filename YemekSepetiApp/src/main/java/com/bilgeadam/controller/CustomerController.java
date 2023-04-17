package com.bilgeadam.controller;

import com.bilgeadam.dto.request.customer.ActivateRequestDto;
import com.bilgeadam.dto.request.customer.CustomerUpdateRequestDto;
import com.bilgeadam.dto.request.customer.LoginRequestDto;
import com.bilgeadam.dto.request.customer.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.repository.entity.Customer;
import com.bilgeadam.repository.entity.jointable.OrderCustomer;
import com.bilgeadam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> login(LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Customer> updateCustomer(CustomerUpdateRequestDto dto){
        return ResponseEntity.ok(customerService.updateCustomer(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping(ORDER_CUSTOMER)
    public List<OrderCustomer> customerOrders(Long customerId){
        return  customerService.customerOrders(customerId);
    }

}
