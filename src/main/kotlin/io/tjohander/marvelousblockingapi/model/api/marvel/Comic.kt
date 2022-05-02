package io.tjohander.marvelous.model.api.marvel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Comic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val issueNumber: Int,
    val variantDescription: String,
    val description: String,
    val modified: Date,
    val format: String,
    val pageCount: Int,
    val textObjects: List<TextObject>,
    val resourceURI: String,
    val urls: List<URL>,
    val series: SeriesSummary,
    val variants: List<ComicSummary>,
    val collections: List<ComicSummary>,
    val collectedIssues: List<ComicSummary>,
    val dates: List<ComicDate>,
    val prices: List<ComicPrice>,
    val thumbnail: Image,
    val images: List<Image>,
    val creators: List<Creator>,
    val characters: List<Character>,
    val stories: List<Story>,
    val events: EventList)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SeriesSummary(
    val resourceURI: String? = null,
    val url: String? = null
)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ComicSummary(
    val resourceURI: String? = null,
    val url: String? = null
)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ComicDate(
    val type: String? = null,
    val date: Date? = null
)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ComicPrice(
    val type: String? = null,
    val price: Float? = null
)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class EventList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<EventSummary>
)

@JsonClass(generateAdapter = true)
@JsonIgnoreProperties(ignoreUnknown = true)
data class EventSummary(
    val resourceURI: String,
    val name: String
)

