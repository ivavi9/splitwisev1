package com.example.splitwisev1.dtos;

import com.example.splitwisev1.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExpenseRequestDTO{

    private long userCreatedBy;
    private long groupId;
    private String description;
    private Map<Long,Long> paidBy;
    private Map<Long,Long> owedBy;

    private long totalAmount;


}
