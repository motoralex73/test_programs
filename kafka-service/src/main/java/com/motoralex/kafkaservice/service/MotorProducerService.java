package com.motoralex.kafkaservice.service;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;

@AllArgsConstructor
@Service
public class MotorProducerService {

    //private static final String TOPIC_NAME = "example-topic";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    //public static void main(String[] args) {
    public void sendMessage(String topic, String message) {
        // Конфигурация producer
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        // Создание producer
        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            // Отправка сообщений
                ProducerRecord<String, String> record =
                        new ProducerRecord<>(topic, "key", message);
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        System.out.printf("Sent message: key message=%s, partition=%d, offset=%d%n",
                                 message, metadata.partition(), metadata.offset());
                    } else {
                        System.err.println("Error sending message: " + exception.getMessage());
                    }
                });
        } finally {
            // Закрытие producer
            producer.close();
        }
    }
}
