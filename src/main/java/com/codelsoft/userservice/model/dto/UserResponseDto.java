package com.codelsoft.userservice.model.dto;


import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponseDto implements Serializable {
    private UUID uuid;
    private String firstname;
    private String lastname;
    private String email;
}