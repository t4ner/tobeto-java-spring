package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.role.AddRoleRequest;
import com.tobeto.homework.services.dtos.requests.role.UpdateRoleRequest;
import com.tobeto.homework.services.dtos.responses.role.GetRoleListResponse;
import com.tobeto.homework.services.dtos.responses.role.GetRoleResponse;

import java.util.List;

public interface RoleService {
    List<GetRoleListResponse> getAll();
    GetRoleResponse getById(int id);
    void add(AddRoleRequest addRoleRequest);
    void update(UpdateRoleRequest updateRoleRequest);
    void delete(int id);
}
