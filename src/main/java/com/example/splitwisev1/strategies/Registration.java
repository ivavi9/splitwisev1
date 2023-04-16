package com.example.splitwisev1.strategies;

import com.example.splitwisev1.dtos.UserRequestDTO;
import com.example.splitwisev1.dtos.UserResponseDTO;
import com.example.splitwisev1.models.User;
import com.example.splitwisev1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class Registration {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        //create and update user details and save it to db
        UserResponseDTO  userResponseDTO = userService.saveUser(userRequestDTO);
        return userResponseDTO;


    }
}
