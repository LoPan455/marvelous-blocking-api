package io.tjohander.marvelous.model.api.marvel

data class URL(
    val type: String,
    val url: String
)

data class TextObject(
    val type: String,
    val language: String,
    val text: String
)

data class ResourceURI(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<Any>
)

data class ResourceList<T>(
    val available: Int,
    val collectionURI: String,
    val items: List<T>
)

data class Image(
    val path: String,
    val extension: String
)