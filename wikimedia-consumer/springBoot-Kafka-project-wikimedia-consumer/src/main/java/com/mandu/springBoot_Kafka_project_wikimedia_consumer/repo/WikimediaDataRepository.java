package com.mandu.springBoot_Kafka_project_wikimedia_consumer.repo;

import com.mandu.springBoot_Kafka_project_wikimedia_consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {



}
