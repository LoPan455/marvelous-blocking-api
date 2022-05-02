package io.tjohander.marvelous.model.api.marvel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Story(
    val id: Int,
    val title: String,
    val description: String,
    val resourceURI: String,
    val type: String,
    val modified: Date,
    val thumbnail: Image,
    val comics: List<Comic>,
    val series: List<Series>,
    val characters: List<Character>,
    val creators: List<Creator>,
    val originalIssue: ComicSummary
)