package com.example.splitwisev1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private long requesterUserId;
    private long groupId;
    private long targetUserId;

}
