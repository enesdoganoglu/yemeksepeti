package com.bilgeadam.controller;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.repository.entity.Order;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.repository.entity.jointable.AllOrder;
import com.bilgeadam.repository.entity.jointable.OrderCustomer;
import com.bilgeadam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constant.ApiUrls.*;

@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(SAVE)
    public ResponseEntity<Order> register(@RequestBody @Valid OrderSaveRequestDto dto){
        return ResponseEntity.ok(orderService.register(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findALl(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(ALL_OORDERS)
    public List<AllOrder> allOrders(){
        return  orderService.allOrders();
    }
}
