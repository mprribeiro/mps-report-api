package com.mps.data_producer.cron;

import com.mps.data_producer.api.producer.KafkaProducer;
import com.mps.data_producer.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
public class GenerateTransaction {

    private final KafkaProducer kafkaProducer;

    @Scheduled(fixedDelay = 5000)
    public void generateTransaction() {
        log.info("Iniciando generateTransaction");
        TransactionModel model = new TransactionModel();
        model.setSeller(RandomStringUtils.random(6, true,false));

        Random random = new Random();
        var transactionsAmountPerUser = random.ints(1, 10)
                .findFirst()
                .getAsInt();

        for (int i=0; i<=transactionsAmountPerUser; i++) {
            model.setBuyer(RandomStringUtils.random(6, true,false));
            model.setAmount(BigDecimal.valueOf(Math.random()));
            model.setCreationDate(LocalDateTime.now());
            kafkaProducer.sendPayment(model);
        }

        log.info("Finalizando generateTransaction");
    }
}
