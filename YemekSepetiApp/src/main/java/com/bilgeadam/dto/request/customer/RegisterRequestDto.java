package com.bilgeadam.dto.request.customer;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank(message = "Müşteri ismi boş olamaz.")
    private String customerName;

    @NotBlank(message = "Müşteri soyismi boş olamaz.")
    private String customerSurname;
    @Email(message = "Lütfen geçerli bir email giriniz.")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük, harf, rakam, ve özel karakterden oluşmalıdır.")
    private String password;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük, harf, rakam, ve özel karakterden oluşmalıdır.")
    private String repassword;
}
