package com.mps.report_generator.service;

import com.mps.report_generator.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final TransactionService transactionService;

    public void generateReportBySeller(String seller) {
        try {
            final var transactionList = transactionService.getTransactionsBySeller(seller);

            if (!transactionList.isEmpty()) {
                OutputStream os = new FileOutputStream(seller.concat(".txt"));
                Writer wr = new OutputStreamWriter(os);
                BufferedWriter br = new BufferedWriter(wr);

                for (TransactionModel model : transactionList) {
                    br.write(model.toString());
                    br.newLine();
                }

                br.close();
            }
        } catch (IOException ignored) {

        }



    }
}
