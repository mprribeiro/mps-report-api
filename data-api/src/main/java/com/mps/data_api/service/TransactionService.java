package com.mps.data_api.service;

import com.mps.data_api.model.TransactionModel;
import com.mps.data_api.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionModel> getAllTransactionsBySeller(String seller) {
        return transactionRepository.findAllBySeller(seller);
    }
}
