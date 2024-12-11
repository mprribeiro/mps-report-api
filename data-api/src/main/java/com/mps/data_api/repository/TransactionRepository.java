package com.mps.data_api.repository;

import com.mps.data_api.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
    List<TransactionModel> findAllBySeller(String seller);
}
