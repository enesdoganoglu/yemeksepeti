package com.bilgeadam.dto.request.customer;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivateRequestDto {
    Long id;
    String activationCodeLogin;
}
