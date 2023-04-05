package com.example.splitwisev1.repositories;

import com.example.splitwisev1.models.Expense;
import com.example.splitwisev1.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {


    @Query(value = "SELECT e.* FROM expense e " +
            "INNER JOIN groups_information_expense_list ge ON e.id = ge.expense_list_id " +
            "WHERE ge.group_id = ?1", nativeQuery = true)
    List<Expense> findAllByGroup_Id(Long groupId);
}
