package com.example.splitwisev1.services;

import com.example.splitwisev1.dtos.ExpenseRequestDTO;
import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExpenseService {

    @Autowired
    UserService userService;
    public Expense manageExpense(ExpenseRequestDTO expenseRequestDTO) {

        Expense expense  = new Expense();
        expense.setAmount(expenseRequestDTO.getTotalAmount());
        expense.setDescription(expenseRequestDTO.getDescription());
        expense.setCreatedAt(new Date());
        userService.addUsersToExpense(expense.getParticipants(),expenseRequestDTO.getOwedBy().keySet());
        expense.setUserCreatedBy(userService.getUserById(expenseRequestDTO.getUserCreatedBy()));


        return expense;
    }
}
