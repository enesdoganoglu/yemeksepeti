package com.bilgeadam.repository.joinrepo;


import com.bilgeadam.repository.entity.jointable.OrdersRestaurant;
import com.bilgeadam.repository.entity.jointable.RestaurantProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurantProductsRepository extends JpaRepository<RestaurantProducts, Long> {

    @Query(nativeQuery = true, value = "select r.restaurant_id, r.restaurant_name,  p.product_id, p.product_name from restaurant as r  \n" +
            "inner join restaurant_product_id as rp on rp.restaurant_restaurant_id = r.restaurant_id\n" +
            "inner join product as p on p.product_id = rp.product_id where r.restaurant_id = ?1"
    )
    List<RestaurantProducts> restaurantProducts(Long restaurantId);
}
