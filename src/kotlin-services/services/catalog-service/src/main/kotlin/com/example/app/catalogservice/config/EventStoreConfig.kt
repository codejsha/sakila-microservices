package com.example.app.catalogservice.config

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.security.NoTypePermission
import org.axonframework.common.transaction.TransactionManager
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine
import org.axonframework.extensions.mongo.spring.SpringMongoTemplate
import org.axonframework.micrometer.GlobalMetricRegistry
import org.axonframework.serialization.xml.XStreamSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory

@Configuration
class EventStoreConfig {
    @Bean
    fun storageEngine(factory: MongoDatabaseFactory, transactionManager: TransactionManager): EventStorageEngine {
        val xStream = XStream()
        xStream.addPermission(NoTypePermission.NONE);
        xStream.allowTypesByWildcard(arrayOf("com.example.app.catalogservice.**", "java.lang.**", "java.util.**"))

        return MongoEventStorageEngine.builder()
            .mongoTemplate(
                SpringMongoTemplate.builder()
                    .factory(factory)
                    .build()
            )
            .eventSerializer(
                XStreamSerializer.builder()
                    .xStream(xStream)
                    .build()
            )
            .snapshotSerializer(
                XStreamSerializer.builder()
                    .xStream(xStream)
                    .build()
            )
            .transactionManager(transactionManager)
            .build()
    }

    @Bean
    fun eventStore(storageEngine: EventStorageEngine, metricRegistry: GlobalMetricRegistry): EventStore {
        return EmbeddedEventStore.builder()
            .storageEngine(storageEngine)
            .messageMonitor(metricRegistry.registerEventBus("eventStore"))
            .build()
    }
}
