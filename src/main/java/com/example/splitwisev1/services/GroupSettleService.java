package com.example.splitwisev1.services;

import com.example.splitwisev1.dtos.ControllerResponseDTO;
import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.repositories.ExpenseRepository;
import com.example.splitwisev1.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupSettleService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired

    GroupRepository groupRepository;


    public ControllerResponseDTO settle(long groupId, long requesterUserId) {

//        if(groupRepository.countUserAsGroupMember(groupId,requesterUserId) == 0){
//            return null;
//        }

        List<Expense> expenseList = expenseRepository.findAllByGroup_Id(groupId);

        System.out.println("Came in group settle service after expense list also");
        expenseList.forEach(System.out::println);


        return null;
    }
}
