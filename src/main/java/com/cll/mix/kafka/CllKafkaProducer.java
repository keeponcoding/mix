package com.cll.mix.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 *@ClassName : CllKafkaProducer
 *@Description : 生产者
 *@Author : pc
 *@Date : 2019/6/22 10:07
 *@Version : 1.0
 **/
public class CllKafkaProducer {

    public static void main(String[] args){
        Properties props = new Properties();
        // 设置连接参数
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer(props);
        for (int a = 0; a <= 10; a++){
            producer.send(new ProducerRecord("topic-name",Integer.valueOf(a)));
        }
        // 关闭
        producer.close();
    }

}
