package com.mps.data_consumer.service;

import com.mps.data_consumer.model.TransactionModel;
import com.mps.data_consumer.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void saveTransaction(TransactionModel model) {
        transactionRepository.save(model);
    }
}
