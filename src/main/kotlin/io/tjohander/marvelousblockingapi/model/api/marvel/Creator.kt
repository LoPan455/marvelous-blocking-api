package io.tjohander.marvelous.model.api.marvel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Creator(
    val id: Int
)