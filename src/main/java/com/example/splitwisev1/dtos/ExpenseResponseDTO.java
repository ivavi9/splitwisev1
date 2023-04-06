package com.example.splitwisev1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseResponseDTO {
    private long userCreatedBy;
    private long groupId;
    private String description;
}
