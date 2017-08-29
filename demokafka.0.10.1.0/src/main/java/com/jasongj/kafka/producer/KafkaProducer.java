package com.jasongj.kafka.producer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhouq
 * @email zhouq@daqsoft.com
 * @date 2017-07-11 16:57
 * @Version:
 * @Describe: kafka 生产者
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public final static String TOPIC = "demo";

//    private final Producer<String, String> producer;

    public KafkaProducer() {
//        Properties props = new Properties();
//        // 此处配置的是kafka的端口
//        props.put("metadata.broker.list", "127.0.0.1:9092");
//        props.put("zk.connect", "127.0.0.1:2181");
//
//        // 配置value的序列化类
//        props.put("serializer.class", "kafka.serializer.StringEncoder");
//        // 配置key的序列化类
//        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
//
//        props.put("request.required.acks", "-1");
//
//        producer = new Producer<String, String>(new ProducerConfig(props));
    }

   public void produce(String msg) {
//        int messageNo = 1000;
//        final int COUNT = 10000;
//
//        while (messageNo < COUNT) {
//            String key = String.valueOf(messageNo);
//            String data = "INFO JobScheduler: Finished job streaming job 1493090727000 ms.0 from job set of time 1493090727000 ms" + key;
//            producer.send(new KeyedMessage<String, String>(TOPIC, key, data));
//            System.out.println(data);
//            messageNo++;
//        }

        if (StringUtils.isNotBlank(msg)){
            //producer.send(new KeyedMessage<String, String>(TOPIC, UUID.randomUUID().toString(), msg));
            kafkaTemplate.send(TOPIC,msg);
        }

    }

    public static void main(String[] args) {
        new KafkaProducer().produce("123");
    }

}
