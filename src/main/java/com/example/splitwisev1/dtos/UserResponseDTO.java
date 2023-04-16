package com.example.splitwisev1.dtos;

import com.example.splitwisev1.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String userName;
    private String phoneNumber;
    private String password;
    public UserResponseDTO(User user) {
        this.userName = user.getUserName();
        this.password = user.getHashedPassword();
        this.phoneNumber = user.getPhoneNumber();

    }

    public UserResponseDTO() {
    }
}