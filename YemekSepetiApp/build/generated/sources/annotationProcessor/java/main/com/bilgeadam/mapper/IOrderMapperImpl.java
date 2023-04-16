package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.OrderSaveRequestDto;
import com.bilgeadam.repository.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T20:47:53+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IOrderMapperImpl implements IOrderMapper {

    @Override
    public Order fromDtoToOrder(OrderSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.restaurantId( dto.getRestaurantId() );
        order.customerId( dto.getCustomerId() );
        List<Long> list = dto.getProductId();
        if ( list != null ) {
            order.productId( new ArrayList<Long>( list ) );
        }

        return order.build();
    }
}
