package com.mps.report_generator.repository;

import com.mps.report_generator.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
    List<TransactionModel> findAllBySeller(String seller);
}
