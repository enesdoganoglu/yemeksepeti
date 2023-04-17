package com.bilgeadam.repository.joinrepo;

import com.bilgeadam.repository.entity.jointable.AllOrder;
import com.bilgeadam.repository.entity.jointable.OrdersRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAllOrders extends JpaRepository<AllOrder, Long> {

    @Query(nativeQuery = true, value = "select opi.order_order_id , r.restaurant_name, p.product_name, c.customer_name ,c.customer_surname from customer as c  \n" +
            "inner join tblorder as tblo on tblo.customer_id = c.customer_id\n" +
            "inner join restaurant as r on r.restaurant_id = tblo.restaurant_id\n" +
            "inner join order_product_id as opi on opi.order_order_id = tblo.order_id\n" +
            "inner join product as p on p.product_id = opi.product_id"
    )
    List<AllOrder> allOrders();
}
