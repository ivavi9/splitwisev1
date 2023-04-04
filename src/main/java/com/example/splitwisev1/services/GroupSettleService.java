package com.example.splitwisev1.services;

import com.example.splitwisev1.dtos.RequestDTO;
import com.example.splitwisev1.dtos.ResponseDTO;
import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.repositories.ExpenseRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupSettleService {

    @Autowired
    ExpenseRepository expenseRepository;

    public ResponseDTO settle(long groupId, long requesterUserId) {

        List<Expense> expenseList = expenseRepository.findByGroupId(groupId);



        return null;
    }
}
