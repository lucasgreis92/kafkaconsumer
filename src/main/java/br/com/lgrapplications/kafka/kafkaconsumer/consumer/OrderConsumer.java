package br.com.lgrapplications.kafka.kafkaconsumer.consumer;

import br.com.lgrapplications.kafka.dto.OrderDTO;
import br.com.lgrapplications.kafka.kafkaconsumer.mapper.OrderMapper;
import br.com.lgrapplications.kafka.kafkaconsumer.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Slf4j
public class OrderConsumer {

    private final Logger log = Logger.getLogger(OrderConsumer.class.getName());

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, OrderDTO> consumerRecord) {

        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Order: " + consumerRecord.value());

        orderRepository
                .save(orderMapper.convertToModel(consumerRecord.value()))
                .doOnError(throwable -> {
                    log.throwing(OrderConsumer.class.getName(),"consumer", throwable);
                })
        .doOnSuccess(order -> {
            log.info("Salvo com sucesso!");
        }).block();

    }
}
