package dev.alansantos.twitter.streams.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TwitterResponse(

    @JsonProperty("payload")
    val tweet: Tweet
)