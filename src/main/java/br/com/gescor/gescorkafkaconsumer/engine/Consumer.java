package br.com.gescor.gescorkafkaconsumer.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.gescor.gescorkafkaconsumer.service.GescorService;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private GescorService service;

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        
        this.service.sendJsonKafka(message);
        
        logger.info(String.format("#### -> sendJsonKafka > %s", message));
    }
}
