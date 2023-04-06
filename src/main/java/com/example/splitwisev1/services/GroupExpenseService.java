package com.example.splitwisev1.services;

import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.Group;
import com.example.splitwisev1.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupExpenseService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserService userService;

    public Group addExpense(Expense expense, long groupId) {
        if(groupRepository.existsById(groupId)){
            groupRepository.getReferenceById(groupId).getExpenseList().add(expense);
        }
        // implement Group not found exception
        return null;
    }
}
