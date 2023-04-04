package com.example.splitwisev1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseModel {

    private String userName;
    private String phoneNumber;
    private String hashedPassword;


}
