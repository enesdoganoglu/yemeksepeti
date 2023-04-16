package com.bilgeadam.repository.joinrepo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderCustomerRepository {
    @Query(nativeQuery = true, value = "select c.customer_name ,c.customer_surname, opi.order_order_id, r.restaurant_name , p.product_name from customer as c \n" +
            "inner join tblorder as tblo on tblo.customer_id = c.customer_id\n" +
            "inner join restaurant as r on r.restaurant_id = tblo.restaurant_id\n" +
            "inner join order_product_id as opi on opi.order_order_id = tblo.order_id\n" +
            "inner join product as p on p.product_id = opi.product_id where c.customer_id = ?1")
    List<OrderCustomer> customerOrders(Long customerId);
}
