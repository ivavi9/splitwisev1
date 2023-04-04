package com.example.splitwisev1.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserExpensePaid extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;

    private long amount;

}
