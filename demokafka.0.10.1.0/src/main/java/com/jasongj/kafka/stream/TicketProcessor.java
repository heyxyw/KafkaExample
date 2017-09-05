package com.jasongj.kafka.stream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

/**
 * @author zhouq
 * @email zhouq@daqsoft.com
 * @date 2017-09-05 14:52
 * @Version:
 * @Describe:
 */
public class TicketProcessor implements Processor<String, String> {

    private ProcessorContext context;
    private KeyValueStore<String,Integer> kvStore;


    @Override
    public void init(ProcessorContext processorContext) {

        this.context = processorContext;
        this.context.schedule(1000);
        this.kvStore = (KeyValueStore<String, Integer>) context.getStateStore("ticketCounts");

    }

    @Override
    public void process(String key, String value) {

    }

    @Override
    public void punctuate(long timestamp) {

    }

    @Override
    public void close() {

    }


}
