package com.mandu.springBoot_Kafka_project_wikimedia_consumer;

import com.mandu.springBoot_Kafka_project_wikimedia_consumer.entity.WikimediaData;
import com.mandu.springBoot_Kafka_project_wikimedia_consumer.repo.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private  static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    //@KafkaListener annotation is used to listen to messages from a Kafka topic
    @KafkaListener(
            topics = "wikimedia_recent_changes",
            groupId = "myGroup"
    )
    private void consume(String eventMessage){
        // Save the event message to the database
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
        LOGGER.info(String.format("Event Message Received: %s",eventMessage));

    }


}
