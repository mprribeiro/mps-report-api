package com.mps.report_generator.service;

import com.mps.report_generator.model.TransactionModel;
import com.mps.report_generator.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionModel> getTransactionsBySeller(final String seller) {
        return transactionRepository.findAllBySeller(seller);
    }
}
