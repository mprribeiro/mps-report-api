package com.mps.data_consumer.api.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.data_consumer.model.TransactionModel;
import com.mps.data_consumer.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DataKafkaConsumer {

    private final TransactionService transactionService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = "transaction-data-topic", groupId = "tr-group", containerFactory = "kafkaListenerContainerFactory")
    public void antiFraud(ConsumerRecord<String, String> record) {
        try {
            var transactionModel = objectMapper.readValue(record.value(), TransactionModel.class);
            //var transactionModel = objectMapper.convertValue(record.value(), TransactionModel.class);
            log.info("Recebi a transação {}", transactionModel.toString());
            transactionService.saveTransaction(transactionModel);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
