package edu.unifei.com242.minicurso.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {

    @KafkaListener(topics = "TopicoProcessoSeletivo", groupId = "the_id")
    public void consume(String message) {
        System.out.println("message = " + message);
    }

}
