package br.edu.unifei.com242.minicurso.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "TopicoProcessoSeletivo";

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") final String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Published...";
    }

}
