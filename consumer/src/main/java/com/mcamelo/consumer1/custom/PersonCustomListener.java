package com.mcamelo.consumer1.custom;


import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@KafkaListener
public @interface PersonCustomListener {
    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupID() default "";

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "person-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "personKafkaListenerContainerFactory";
//    String containerFactory() default "jsonKafkaListenerContainerFactory";
}
