package com.bilgeadam.repository.entity.jointable;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderCustomer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String customerName;

    private String customerSurname;

    private Long order_order_id;

    private String restaurantName;

    private String productName;








}
