package io.tjohander.marvelous.model.api.marvel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Character(
    val id: String,
    val name: String,
    val description: String,
    val resourceURI: String,
    val urls: List<URL>,
    val thumbnail: Image,
//    @JsonClass(generateAdapter = true)
    val comics: ResourceList<Comic>,
    val stories: ResourceList<Story>,
    val events: ResourceList<Event>,
    val series: ResourceList<Series>
)