package com.mcamelo.consumer1.listerner;

import com.mcamelo.consumer1.custom.PersonCustomListem;
import com.mcamelo.consumer1.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Slf4j
@Component
public class TestListener1 {

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    public void listen(String message){
        log.info(message);
    };

//    @KafkaListener(topics = "person-topic", groupId = "group-1", containerFactory = "personKafkaListenerContainerFactory")
//    public void listenPerson(Person person){
//        log.info("Person: " + person);
//    };
//    @KafkaListener(topics = "person-topic", groupId = "group-1", containerFactory = "personKafkaListenerContainerFactory")
    @PersonCustomListem(groupID = "group-1")
    public void create(Person person){
        log.info("created: Thread: {} ", Thread.currentThread().getId());
        log.info("created: Person: {} ",person);
    };

//   @KafkaListener(topics = "person-topic", groupId = "group-2", containerFactory = "personKafkaListenerContainerFactory")
    @PersonCustomListem(groupID = "group-2")
    public void history(Person person){
        log.info("history: Thread: {} ", Thread.currentThread().getId());
        log.info("history: Person: {} ", person);
    };



    }
//    @KafkaListener(topics = "topic-1", groupId = "group-1")
//    public void listen(String message,
////                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
////                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                       ConsumerRecordMetadata metadata
//    ){
////        log.info("Thread: {}", Thread.currentThread().getId());
////        log.info("Recceived: {}", message);
////        log.info("Topic: {}, Pt {} : {}", topic, id, message);
//        log.info("Topic: {}, Pt {} : Offset {} : {}", metadata.topic(), metadata.partition(), metadata.offset(), message);
//        log.info("Timestamp: {} ", LocalDateTime.ofInstant(
//                Instant.ofEpochMilli(metadata.timestamp()),
//                TimeZone.getDefault().toZoneId()
//        ));
//    }

