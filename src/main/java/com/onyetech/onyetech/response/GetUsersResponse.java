package com.onyetech.onyetech.response;

import com.onyetech.onyetech.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUsersResponse {
    private List<User> users;
}
