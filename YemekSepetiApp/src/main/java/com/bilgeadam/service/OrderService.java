package com.bilgeadam.service;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.exception.CustomerManagerException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.mapper.IOrderMapper;
import com.bilgeadam.repository.ICustomerRepository;
import com.bilgeadam.repository.IOrderRepository;
import com.bilgeadam.repository.entity.Customer;
import com.bilgeadam.repository.entity.Order;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.utility.CodeGenerator;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long> {

    private final ICustomerRepository customerRepository;
    private final IOrderRepository orderRepository;
    public OrderService(ICustomerRepository customerRepository, IOrderRepository orderRepository) {
        super(orderRepository);
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public Order register(OrderSaveRequestDto dto){
        Order order = IOrderMapper.INSTANCE.fromDtoToOrder(dto);
        Optional<Customer> customer = customerRepository.findById(dto.getCustomerId());
        if(customer.get().getAddress().isEmpty() || customer.get().getCardDetails().isEmpty()
                || customer.get().getEmail().isEmpty())
            throw new CustomerManagerException(ErrorType.REGUIRED_USER_INFORMATION_NOT_FOUND);

        customer.get().setActivationCodeOrder(CodeGenerator.generateCode());

        if(!customer.get().getActivationCodeOrder().isEmpty()) {
            return orderRepository.save(order);
        }
        throw new CustomerManagerException(ErrorType.ACTIVATE_CODE_ERROR);

    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

}
