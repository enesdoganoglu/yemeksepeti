package com.bilgeadam.dto.request.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerUpdateRequestDto {
    Long id;
    @NotBlank(message = "Müşteri ismi boş olamaz.")
    String customerName;
    @NotBlank(message = "Müşteri soyismi boş olamaz.")
    String customerSurname;
    @Email(message = "Lütfen geçerli bir email giriniz.")
    String email;
    @NotBlank(message = "Müşteri adresi boş olamaz.")
    String Address;
    String phoneNumber;
    @NotBlank(message = "Müşteri kart bilgisi boş olamaz.")
    String cardDetails;
    Long balance;
    String password;
    String repassword;
}
