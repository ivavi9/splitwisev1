package com.example.splitwisev1.models;


import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {

    private String description;
    private long amount;

    @ManyToOne
    private User userCreatedBy;

    private Date createdAt;

//    @Enumerated(EnumType.ORDINAL)
//    private Currency baseCurrency;
    @ManyToMany
    private List<User> participants;

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", userCreatedBy=" + userCreatedBy +
                ", createdAt=" + createdAt +
                ", participants=" + participants +
                '}';
    }
}
