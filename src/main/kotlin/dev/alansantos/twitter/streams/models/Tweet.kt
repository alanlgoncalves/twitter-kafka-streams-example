package dev.alansantos.twitter.streams.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Tweet(

    @JsonProperty("Text")
    val text: String,

    @JsonProperty("Lang")
    val lang: String,

    @JsonProperty("User")
    val user: TwitterUser
)