package com.onyetech.onyetech.dto;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class SignUpDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
