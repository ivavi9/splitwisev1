package com.example.splitwisev1.strategies;

import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.User;

import java.util.List;
import java.util.Map;

public interface SettleController {
    public Map<User,Long> getDues(List<Expense> expenseList);
}
