package edu.com242.minicurso;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

public class MinicursoProducer {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("minicurso-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            template.send("minicurso-topic", "test");
        };
    }

}
