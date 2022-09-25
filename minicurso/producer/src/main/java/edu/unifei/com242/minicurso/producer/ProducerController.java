package edu.unifei.com242.minicurso.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private static final String TOPIC_NAME = "TopicoProcessoSeletivo";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message") final String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Published successfully...";
    }

}
