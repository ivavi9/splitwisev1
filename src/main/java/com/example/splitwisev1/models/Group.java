package com.example.splitwisev1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "groupsInformation")
public class Group extends BaseModel {

    private String name;


    @ManyToMany
    private List<User> participants;

    @ManyToMany
    private List<User> admins;


    @ManyToOne
    private User userCreatedBy;

    private Date createTime;

    @OneToMany
    private List<Expense> expenseList;

}
