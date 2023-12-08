package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.homework.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.homework.services.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.homework.services.dtos.responses.employee.GetEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetEmployeeListResponse> getAll();
    GetEmployeeResponse getById(int id);
    void add(AddEmployeeRequest addEmployeeRequest);
    void update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
}
