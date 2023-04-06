package com.example.splitwisev1.strategies;

import com.example.splitwisev1.dtos.ExpenseRequestDTO;
import com.example.splitwisev1.dtos.ExpenseResponseDTO;
import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.Group;
import com.example.splitwisev1.services.ExpenseService;
import com.example.splitwisev1.services.GroupExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private GroupExpenseService groupExpenseService;

    @PostMapping("/group")
    public ResponseEntity<?> addGroupExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO){

//        expenseRequestDTO.getOwedBy().values().forEach(System.out::println);

        // Ask ExpenseService to take the expenseRequestDTO and save it and return an expense object

        Expense expense = expenseService.manageExpense(expenseRequestDTO);
        Group group = groupExpenseService.addExpense(expense,expenseRequestDTO.getGroupId());






        ExpenseResponseDTO expenseResponseDTO = new ExpenseResponseDTO();
        expenseResponseDTO.setDescription(expenseRequestDTO.getDescription());
        expenseResponseDTO.setGroupId(expenseRequestDTO.getGroupId());
        expenseResponseDTO.setUserCreatedBy(expenseRequestDTO.getUserCreatedBy());

        return new ResponseEntity<>(expenseResponseDTO,HttpStatus.CREATED);

    }

}
