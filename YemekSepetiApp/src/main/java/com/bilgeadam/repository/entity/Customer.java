package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.entity.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(length = 50)

    private String customerName;
    @Column(length = 50)
    private String customerSurname;

    private String email;


    private String Address;

    private String phoneNumber;
    @Column(length = 32)


    private String password;
    @Column(length = 32)



    private String cardDetails;

    private Long balance;

    private String activationCodeLogin;

    private String activationCodeOrder;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;




}
