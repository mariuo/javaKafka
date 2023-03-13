package com.mcamelo.producer.controller;

import com.mcamelo.producer.model.City;
import com.mcamelo.producer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    //    @GetMapping("/send")
//    public ResponseEntity<?> send(){
////        kafkaTemplate.send("topic-1", "Send de: "+ LocalDateTime.now());
//        IntStream.range(1,10)
//                .boxed()
//                .forEach(n ->
//                {
//                    System.out.println(LocalDateTime.now());
//                    kafkaTemplate.send("topic-1", "message "+ n);
//                });
//        return ResponseEntity.ok().build();
//    }
    @GetMapping("/send")
    public void send() {
                    kafkaTemplate.send("topic-1", "Teste");

    }

    @GetMapping("/sendTopic")
    public void send2() {

                    kafkaTemplate.send("my-topic", "My topic");
    }

    @GetMapping("/sendPerson")
    public void sendPerson() {
        jsonKafkaTemplate.send("person-topic", new Person("Joao", 10));
    }
    @GetMapping("/sendCity")
    public void sendCity() {
        jsonKafkaTemplate.send("city-topic", new City("Montreal", "MTL"));
    }
}
