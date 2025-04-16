package com.mandu.springBoot_Kafka_project_wikimedia;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WikimediaChangesProducer {

    private static final String TOPIC = "wikimedia_recent_changes";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final WebClient webClient;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate, WebClient.Builder webClientBuilder) {
        this.kafkaTemplate = kafkaTemplate;
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2/stream/recentchange").build();
    }

    public void startStreaming() {
        // Use WebClient to subscribe to the Wikimedia stream (SSE)
        Flux<String> eventStream = webClient.get()
                .retrieve()
                .bodyToFlux(String.class); // Body is expected to be the event stream

        eventStream.subscribe(message -> {
            // Send each message to Kafka
            kafkaTemplate.send(TOPIC, message);
            System.out.println("Sent message to Kafka: " + message);
        });
    }
}
