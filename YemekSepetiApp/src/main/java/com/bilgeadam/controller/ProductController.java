package com.bilgeadam.controller;


import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bilgeadam.constant.ApiUrls.*;


@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Product> save(@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findALl(){
        return ResponseEntity.ok(productService.findAll());
    }
}
