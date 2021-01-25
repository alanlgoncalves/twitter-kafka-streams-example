package dev.alansantos.twitter.streams.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TwitterUser(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("ScreenName")
    val username: String,

    @JsonProperty("FollowersCount")
    val followersCount: Long
)