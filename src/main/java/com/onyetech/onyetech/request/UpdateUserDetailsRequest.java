package com.onyetech.onyetech.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdateUserDetailsRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;


}
