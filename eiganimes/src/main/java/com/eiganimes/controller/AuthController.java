package com.eiganimes.controller;

import com.eiganimes.controller.request.UserRequest;
import com.eiganimes.controller.response.UserResponse;
import com.eiganimes.entity.User;
import com.eiganimes.mapper.UserMapper;
import com.eiganimes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eiganimes/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        User savedUser = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse((savedUser)));
    }

}
