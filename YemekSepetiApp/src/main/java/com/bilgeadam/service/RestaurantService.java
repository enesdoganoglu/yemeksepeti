package com.bilgeadam.service;

import com.bilgeadam.dto.request.ProductSaveRequestDto;
import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.mapper.IProductMapper;
import com.bilgeadam.mapper.IRestaurantMapper;
import com.bilgeadam.repository.IRestaurantRepository;
import com.bilgeadam.repository.entity.Product;
import com.bilgeadam.repository.entity.Restaurant;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {

    private final IRestaurantRepository repository;
    public RestaurantService( IRestaurantRepository repository) {
        super(repository);
        this.repository = repository;
    }
    public Restaurant save(RestaurantSaveRequestDto dto){
        Restaurant restaurant = IRestaurantMapper.INSTANCE.fromDtoToRestaurant(dto);
        return repository.save(restaurant);
    }

    public List<Restaurant> findAll(){
        return repository.findAll();
    }
}
