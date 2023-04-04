package com.example.splitwisev1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserExpenseHasToPay extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;
    private long amount;

}
