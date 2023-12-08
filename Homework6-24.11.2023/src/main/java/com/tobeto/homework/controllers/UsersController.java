package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.UserService;
import com.tobeto.homework.services.dtos.requests.user.AddUserRequest;
import com.tobeto.homework.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.homework.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.homework.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("id/users")
@AllArgsConstructor
public class UsersController {
  private final UserService userService;

    @GetMapping
    public List<GetUserListResponse> getAll(){
       return userService.getAll();
    }

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddUserRequest addUserRequest){
       userService.add(addUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest){
       userService.update(updateUserRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
       userService.delete(id);
    }
}
