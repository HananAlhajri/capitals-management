package com.demo.capmgnmt.common.mapper;

import com.demo.capmgnmt.dto.request.NewUserRequest;
import com.demo.capmgnmt.dto.response.UserResponse;
import com.demo.capmgnmt.entity.User;
import org.mapstruct.Mapper;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapRequestToUser(NewUserRequest request);
    UserResponse mapUserToResponse(User user);
}