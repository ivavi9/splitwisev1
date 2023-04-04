package com.example.splitwisev1.dtos;


import com.example.splitwisev1.models.Currency;
import com.example.splitwisev1.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseDTO
{
    private Map<User,Long> settlementAmount;
    private String description;
    private long requesterUserId;
    private long targetUserId;
    private long groupId;

    private Currency currency;

}
