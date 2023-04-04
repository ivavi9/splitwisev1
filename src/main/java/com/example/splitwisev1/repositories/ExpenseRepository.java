package com.example.splitwisev1.repositories;

import com.example.splitwisev1.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByGroupId(Long groupId);
}
