package com.tobeto.homework.services.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}