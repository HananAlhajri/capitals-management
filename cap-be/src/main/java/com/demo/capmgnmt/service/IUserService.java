package com.demo.capmgnmt.service;

import com.demo.capmgnmt.dto.request.NewUserRequest;
import com.demo.capmgnmt.dto.request.UpdateUserRequest;
import com.demo.capmgnmt.dto.response.UserResponse;

public interface IUserService {
    void createUser(NewUserRequest newUser);
    UserResponse updateUser(Long id, UpdateUserRequest newInfo);
    void deleteUser(Long id);
}