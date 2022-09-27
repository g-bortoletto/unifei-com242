package br.edu.unifei.com242.minicurso.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("msg/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("new-topic", message);
        return ResponseEntity.ok().build();
    }

    @GetMapping("function/{a}/{b}")
    public ResponseEntity<?> calculateFunction(@PathVariable("a") String a, @PathVariable("b") String b) {
        Double cateto_a = Double.valueOf(a);
        Double cateto_b = Double.valueOf(b);

        Double resultado = Math.sqrt(cateto_a * cateto_a + cateto_b * cateto_b);
        String r = resultado.toString();

        kafkaTemplate.send("new-topic", r);

        return ResponseEntity.ok().build();
    }

    @GetMapping("file/{message}")
    public ResponseEntity<?> updateFile(@PathVariable("message") String message) {
        kafkaTemplate.send("new-topic", "m_" + message);
        return ResponseEntity.ok().build();
    }

}
