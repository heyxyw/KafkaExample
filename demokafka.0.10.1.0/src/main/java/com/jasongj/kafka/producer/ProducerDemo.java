
package com.jasongj.kafka.producer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.*;

/**
 * @author zhouq
 * @email zhouq@daqsoft.com
 * @date 2017-07-11 13:48
 * @Version:
 * @Describe: kafka Producer 测试
 */
public class ProducerDemo {

    public static void main(String[] args) {
        int events = 20;
        // @see http://kafka.apache.org/08/configuration.html-- 3.3 Producer
        // Configs
        // @see http://kafka.apache.org/documentation.html#producerconfigs
        // 设置配置属性
        Properties props = new Properties();
        props.put("metadata.broker.list", "192.168.2.125:9092"); // 配置kafka的IP和端口
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        // key.serializer.class默认为serializer.class
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        // 可选配置，如果不配置，则使用默认的partitioner
//        props.put("partitioner.class", "com.kafka.demo.PartitionerDemo");
        // 触发acknowledgement机制，否则是fire and forget，可能会引起数据丢失
        // 值为0,1,-1,可以参考
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);

        // 创建producer
        Producer<String, String> producer = new Producer<String, String>(config);
        // 产生并发送消息
        long start = System.currentTimeMillis();
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        //strings.get()
        for (long i = 0; i < events; i++) {
            long runtime = new Date().getTime();
            String ip = "a " + i;
            // 如果topic不存在，则会自动创建，默认replication-factor为1，partitions为0
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("ticketMetadata10", ip);
//            System.out.println("-----Kafka Producer----createMessage----" + data);
            producer.send(data);
        }
        System.out.println("Time consuming:" + (System.currentTimeMillis() - start));
        // 关闭producer
        producer.close();



    }
}

