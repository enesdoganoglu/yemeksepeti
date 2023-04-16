package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RestaurantSaveRequestDto;
import com.bilgeadam.repository.entity.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T20:34:39+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IRestaurantMapperImpl implements IRestaurantMapper {

    @Override
    public Restaurant fromDtoToRestaurant(RestaurantSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Restaurant.RestaurantBuilder restaurant = Restaurant.builder();

        restaurant.restaurantName( dto.getRestaurantName() );
        restaurant.address( dto.getAddress() );
        restaurant.point( dto.getPoint() );
        List<Long> list = dto.getProductId();
        if ( list != null ) {
            restaurant.productId( new ArrayList<Long>( list ) );
        }

        return restaurant.build();
    }
}
