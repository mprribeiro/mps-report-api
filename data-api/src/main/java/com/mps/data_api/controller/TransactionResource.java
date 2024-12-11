package com.mps.data_api.controller;

import com.mps.data_api.model.TransactionModel;
import com.mps.data_api.service.TransactionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionResource {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionModel>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/seller/{seller}")
    public ResponseEntity<List<TransactionModel>> getAllTransactionsBySeller(@PathVariable("seller") String seller) {
        return ResponseEntity.ok(transactionService.getAllTransactionsBySeller(seller));
    }
}
