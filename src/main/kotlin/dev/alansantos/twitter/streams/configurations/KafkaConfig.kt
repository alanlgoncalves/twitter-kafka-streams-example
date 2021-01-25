package dev.alansantos.twitter.streams.configurations

import org.apache.kafka.streams.StreamsConfig
import java.util.*

class KafkaConfig {

    fun getProperties(): Properties {
        val properties = Properties();

        properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
        properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "twitter-kafka-streams")
        properties.setProperty(
            StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.Serdes\$StringSerde"
        )
        properties.setProperty(
            StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
            "org.apache.kafka.common.serialization.Serdes\$StringSerde"
        )

        return properties
    }

}