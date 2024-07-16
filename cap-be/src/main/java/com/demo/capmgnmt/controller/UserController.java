package com.demo.capmgnmt.controller;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.dto.request.NewUserRequest;
import com.demo.capmgnmt.dto.request.UpdateUserRequest;
import com.demo.capmgnmt.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.demo.capmgnmt.common.constants.APIsUrl.User.*;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<?> register(@Valid @RequestBody NewUserRequest newUser) {
        userService.createUser(newUser);
        return APIResponse.success();
    }

    @PutMapping(UPDATE_USER + "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UpdateUserRequest newInfo) {
        return APIResponse.success(userService.updateUser(id, newInfo));
    }

    @DeleteMapping(DELETE_USER + "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return APIResponse.success();
    }
}