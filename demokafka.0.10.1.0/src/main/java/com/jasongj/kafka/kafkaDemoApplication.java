package com.jasongj.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class kafkaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(kafkaDemoApplication.class, args);
    }
}
