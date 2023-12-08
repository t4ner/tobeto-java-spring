package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.user.AddUserRequest;
import com.tobeto.homework.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.homework.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.homework.services.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    void add(AddUserRequest addUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
}
