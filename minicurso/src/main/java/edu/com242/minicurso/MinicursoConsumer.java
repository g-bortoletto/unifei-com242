package edu.com242.minicurso;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

public class MinicursoConsumer {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("minicurso-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id="MainId", topics="minicurso-topic")
    public void listen(String in) {
        System.out.println(in);
    }

}
