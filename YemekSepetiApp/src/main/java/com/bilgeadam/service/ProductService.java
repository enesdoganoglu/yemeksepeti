package com.bilgeadam.service;


import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.mapper.IProductMapper;
import com.bilgeadam.repository.IProductRepository;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceManager<Product,Long> {

    private final IProductRepository repository;
    public ProductService( IProductRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public Product save(ProductSaveRequestDto dto){
        Product product = IProductMapper.INSTANCE.fromDtoToProduct(dto);
        return repository.save(product);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }
}
