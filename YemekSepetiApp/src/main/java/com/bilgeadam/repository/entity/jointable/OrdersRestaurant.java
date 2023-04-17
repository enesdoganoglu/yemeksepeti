package com.bilgeadam.repository.entity.jointable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrdersRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_order_id;

    private String restaurantName;

    private String productName;

    private String customerName;

    private String customerSurname;
}
