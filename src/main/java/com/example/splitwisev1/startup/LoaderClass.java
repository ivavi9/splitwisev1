package com.example.splitwisev1.startup;

import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.Group;
import com.example.splitwisev1.models.User;
import com.example.splitwisev1.models.UserExpenseHasToPay;
import com.example.splitwisev1.repositories.ExpenseRepository;
import com.example.splitwisev1.repositories.GroupRepository;
import com.example.splitwisev1.repositories.UserExpenseHasToPayRepository;
import com.example.splitwisev1.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class LoaderClass {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserExpenseHasToPayRepository userExpenseHasToPayRepository;




    @PostConstruct
    public void init() {
        // populate users
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUserName("User " + i);
            user.setPhoneNumber("12345678" + i);
            user.setHashedPassword("password" + i);
            userRepository.save(user);
        }

        // populate groups
        for (long i = 1; i <= 10; i++) {
            Group group = new Group();
            group.setName("Group " + i);
            group.setCreateTime(new Date());
            group.setUserCreatedBy(userRepository.findById(i).get());
            group.setAdmins(Arrays.asList(userRepository.findById(i).get()));
            if(i > 2){
                group.setParticipants(Arrays.asList(userRepository.findById(i).get(), userRepository.findById(i-1).get(), userRepository.findById(i-2).get()));

            }else{
                group.setParticipants(Arrays.asList(userRepository.findById(i).get()));

            }
            groupRepository.save(group);
        }

        // populate expenses
        for (long i = 1; i <= 10; i++) {
            Expense expense = new Expense();
            expense.setDescription("Expense " + i);
            expense.setAmount(i * 100);
            expense.setUserCreatedBy(userRepository.findById(i).get());
            expense.setCreatedAt(new Date());
            if(i > 1) {
                expense.setParticipants(Arrays.asList(userRepository.findById(i).get(), userRepository.findById(i - 1).get()));
            }else{
                expense.setParticipants(Arrays.asList(userRepository.findById(i).get()));
            }
            expenseRepository.save(expense);
        }

        for (long i = 1; i <= 10; i++) {
            User user = userRepository.findById(i).get();
            Group group = groupRepository.findById(i).get();

            // create an expense
            Expense expense = new Expense();
            expense.setDescription("Expense " + i);
            expense.setAmount(i * 100);
            expense.setUserCreatedBy(user);
            expense.setCreatedAt(new Date());
            expense.setParticipants(Arrays.asList(user));
            expenseRepository.save(expense);

            // add the expense to the group

            List<Expense> expenseList = group.getExpenseList();
            expenseList.add(expense);
            group.setExpenseList(expenseList);
            groupRepository.save(group);
        }

        for (long i = 1; i <= 10; i++) {
            User user = userRepository.findById(i).get();
            Expense expense = expenseRepository.findById(i).get();

            UserExpenseHasToPay userExpenseHasToPay = new UserExpenseHasToPay();
            userExpenseHasToPay.setUser(user);
            userExpenseHasToPay.setExpense(expense);
            userExpenseHasToPay.setAmount(i * 10);

            userExpenseHasToPayRepository.save(userExpenseHasToPay);
        }


    }
}
