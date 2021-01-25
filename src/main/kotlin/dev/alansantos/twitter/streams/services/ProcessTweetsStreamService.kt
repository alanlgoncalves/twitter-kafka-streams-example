package dev.alansantos.twitter.streams.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.alansantos.twitter.streams.models.TwitterResponse
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import java.util.*

class ProcessTweetsStreamService(private val properties: Properties) {

    fun execute() {
        val streamBuilder = StreamsBuilder()

        streamBuilder.stream<String, String>("twitter_tweets")
            .mapValues { json -> jacksonObjectMapper().readValue<TwitterResponse>(json).tweet }
            .filter { _, tweet -> tweet.lang == "en" && tweet.user.followersCount >= 10000 }
            .mapValues { tweet ->
                "O usuário ${tweet.user.username} com ${tweet.user.followersCount} followers " +
                        "escrever o seguinte texto: ${tweet.text}"
            }
            .to("processed_twitter_tweets")

        KafkaStreams(streamBuilder.build(), properties).start()
    }

}