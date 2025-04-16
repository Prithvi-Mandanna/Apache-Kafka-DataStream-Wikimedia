package com.mandu.springBoot_Kafka_project_wikimedia_consumer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wikimedia_recent_change")
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String wikiEventData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
