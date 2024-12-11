package com.mps.data_producer.api.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.data_producer.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
@Log4j2
public class KafkaProducer {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendPayment(TransactionModel model) {
        kafkaTemplate.send("transaction-data-topic", objectMapper.writeValueAsString(model));
    }
}
