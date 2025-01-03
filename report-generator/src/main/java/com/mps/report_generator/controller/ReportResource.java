package com.mps.report_generator.controller;

import com.mps.report_generator.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportResource {

    private final ReportService reportService;

    @GetMapping("/seller/{seller}")
    public ResponseEntity<Object> getAllTransactionsBySeller(@PathVariable("seller") String seller) {
        reportService.generateReportBySeller(seller);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
