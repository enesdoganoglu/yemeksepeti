package com.bilgeadam.service;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.mapper.IRestaurantMapper;
import com.bilgeadam.repository.IRestaurantRepository;
import com.bilgeadam.repository.entity.Restaurant;
import com.bilgeadam.repository.entity.jointable.OrdersRestaurant;
import com.bilgeadam.repository.entity.jointable.RestaurantProducts;
import com.bilgeadam.repository.joinrepo.IOrdersRestaurantRepository;
import com.bilgeadam.repository.joinrepo.IRestaurantProductsRepository;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {

    private final IRestaurantRepository repository;

    private final IOrdersRestaurantRepository ordersRestaurantRepository;

    private final IRestaurantProductsRepository restaurantProductsRepository;
    public RestaurantService(IRestaurantRepository repository, IOrdersRestaurantRepository ordersRestaurantRepository, IRestaurantProductsRepository restaurantProductsRepository) {
        super(repository);
        this.repository = repository;
        this.ordersRestaurantRepository = ordersRestaurantRepository;
        this.restaurantProductsRepository = restaurantProductsRepository;
    }
    public Restaurant save(RestaurantSaveRequestDto dto){
        Restaurant restaurant = IRestaurantMapper.INSTANCE.fromDtoToRestaurant(dto);
        return repository.save(restaurant);
    }

    public List<Restaurant> findAll(){
        return repository.findAll();
    }

    public List<OrdersRestaurant> restaurantOrders(Long restaurantId){
        return  ordersRestaurantRepository.restaurantOrders(restaurantId);
    }

    public List<RestaurantProducts> restaurantProducts(Long restaurantId){
        return  restaurantProductsRepository.restaurantProducts(restaurantId);
    }
}
