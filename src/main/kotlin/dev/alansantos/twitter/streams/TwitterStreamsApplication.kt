package dev.alansantos.twitter.streams

import dev.alansantos.twitter.streams.configurations.KafkaConfig
import dev.alansantos.twitter.streams.services.ProcessTweetsStreamService

fun main() {
    val properties = KafkaConfig().getProperties()

    ProcessTweetsStreamService(properties).execute()
}