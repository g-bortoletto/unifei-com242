package br.edu.unifei.com242.minicurso.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class TestListener {

    @KafkaListener(topics = "new-topic", groupId = "group-1")
    public void listen(String message) {
        System.out.print("Thread " + Thread.currentThread().getId());
        System.out.println(" received: " + message);

        if (message.startsWith("m_")) {
            try {
                Path filePath = Paths.get("./file.txt");
                if (!Files.exists(filePath)) {
                    Files.createFile(filePath);
                }
                Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
