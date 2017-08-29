package com.jasongj.kafka.stream;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;
import org.apache.kafka.streams.state.Stores;

import java.io.IOException;
import java.util.Properties;

public class WordCountTopology {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount-processor1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.125:9092");
        props.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, "192.168.2.125:2181");
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.addSource("SOURCE", new StringDeserializer(), new StringDeserializer(), "ticketMetadata11")
				.addProcessor("WordCountP4", WordCountProcessor::new, "SOURCE")
				.addStateStore(Stores.create("Counts").withStringKeys().withIntegerValues().inMemory().build(), "WordCountP4")
//				.connectProcessorAndStateStores("WordCountProcessor", "Counts")
				.addSink("SINK", "count14", new StringSerializer(), new LongSerializer(), "WordCountP4");
		
        KafkaStreams stream = new KafkaStreams(builder, props);
        stream.start();
        System.in.read();
        stream.close();
        stream.cleanUp();
	}

}
