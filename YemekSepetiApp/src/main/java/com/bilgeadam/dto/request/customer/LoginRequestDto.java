package com.bilgeadam.dto.request.customer;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {
    String customerName;
    String password;
}
