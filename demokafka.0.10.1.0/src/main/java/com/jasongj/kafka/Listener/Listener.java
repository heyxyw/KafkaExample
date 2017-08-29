package com.jasongj.kafka.Listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouq
 * @email zhouq@daqsoft.com
 * @date 2017-08-25 10:40
 * @Version:
 * @Describe:
 */
@Component
public class Listener {

//    //    /**
////     * 消费 topic 为 demo 的消息
////     * @param content
////     */
//    @KafkaListener(id = "zhouq-001",topics = "zhouq",group = "001")
//    public void ticketMetadata(ConsumerRecord data) {
//
//        System.out.println("zhouq:");
//        System.out.println("topic:"+data.topic());
//        System.out.println("value:"+data.value());
//        System.out.println("key:"+data.key());
//        System.out.println("offset:"+data.offset());
//        System.out.println("partition:"+data.partition());
//        System.out.println("checksum:"+data.checksum());
//        System.out.println("timestampType:"+data.timestampType());
//        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
//        System.out.println("---------------------------------------------------------");
////        String format = String.format("processMessage 消费消息---> group:%s,topic:%s,msg:%s", "001", "zhouq",content);
////        System.out.println(format);
//    }
//
//    //    /**
////     * 消费 topic 为 demo 的消息
////     * @param content
////     */
//    @KafkaListener(id = "zhouq-001",topics = "zhouq",group = "001")
//    public void processMessage(ConsumerRecord data) {
//
//        System.out.println("zhouq:");
//        System.out.println("topic:"+data.topic());
//        System.out.println("value:"+data.value());
//        System.out.println("key:"+data.key());
//        System.out.println("offset:"+data.offset());
//        System.out.println("partition:"+data.partition());
//        System.out.println("checksum:"+data.checksum());
//        System.out.println("timestampType:"+data.timestampType());
//        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
//        System.out.println("---------------------------------------------------------");
////        String format = String.format("processMessage 消费消息---> group:%s,topic:%s,msg:%s", "001", "zhouq",content);
////        System.out.println(format);
//    }
//
//    @KafkaListener(id="wordCount-001",topics = "wordCount",group = "001")
//    public void wordCount(String content) {
//        String format = String.format("wordCount 消费消息---> group:%s,topic:%s,msg:%s", "001", "wordCount",content);
//        System.out.println(format);
//    }

//    @KafkaListener(id = "consumer-count5",topics = "count5",group = "001")
//    public void consumerCount5(ConsumerRecord data) {
//        Object value = data.value();
//        DefaultMessageFormatter defaultMessageFormatter = new DefaultMessageFormatter();
//        Option<Deserializer<?>> deserializerOption = defaultMessageFormatter.keyDeserializer();
//
//        System.out.println("data");
//        System.out.println("topic:"+data.topic());
//        System.out.println("value:"+data.value());
//        System.out.println("key:"+data.key());
//        System.out.println("offset:"+data.offset());
//        System.out.println("partition:"+data.partition());
//        System.out.println("checksum:"+data.checksum());
//        System.out.println("timestampType:"+data.timestampType());
//        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
//        System.out.println("---------------------------------------------------------");
//    }


    @KafkaListener(id = "consumer-wordCount1",topics = "wordCount1")
    public void consumerCount6(ConsumerRecord<String,String> data) {

        System.out.println("wordCount1:");
        System.out.println("topic:"+data.topic());
        System.out.println("value:"+data.value());
        System.out.println("key:"+data.key());
        System.out.println("offset:"+data.offset());
        System.out.println("partition:"+data.partition());
        System.out.println("checksum:"+data.checksum());
        System.out.println("timestampType:"+data.timestampType());
        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
        System.out.println("---------------------------------------------------------");
    }
//
//    @KafkaListener(id = "consumer-count7",topics = "count12")
//    public void consumerCount7(ConsumerRecord<String,Long> data) {
//        System.out.println("count12:");
//        System.out.println("topic:"+data.topic());
//        System.out.println("value:"+data.value());
//        System.out.println("key:"+data.key());
//        System.out.println("offset:"+data.offset());
//        System.out.println("partition:"+data.partition());
//        System.out.println("checksum:"+data.checksum());
//        System.out.println("timestampType:"+data.timestampType());
//        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
//        System.out.println("---------------------------------------------------------");
//    }
//
//    @KafkaListener(id = "consumer-count8",topics = "count14")
//    public void consumerCount8(ConsumerRecord<String,Long> data) {
//        System.out.println("count14:");
//        System.out.println("topic:"+data.topic());
//        System.out.println("value:"+data.value());
//        System.out.println("key:"+data.key());
//        System.out.println("offset:"+data.offset());
//        System.out.println("partition:"+data.partition());
//        System.out.println("checksum:"+data.checksum());
//        System.out.println("timestampType:"+data.timestampType());
//        System.out.println("timestamp:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss:SSS").format(new Date(data.timestamp())));
//        System.out.println("---------------------------------------------------------");
//    }
}
