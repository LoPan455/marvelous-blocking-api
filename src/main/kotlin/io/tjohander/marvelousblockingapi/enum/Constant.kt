package io.tjohander.marvelousblockingapi.enum

enum class MarvelApiUrls(val value: String) {
    SCHEME("https"),
    HOST("gateway.marvel.com"),
    BASE_URL("https://gateway.marvel.com/v1/public/"),
    API_VERSION("v1"),
    PUBLIC("public"),
    CHARACTER_PATH("characters"),
    COMICS_PATH("comics"),
    EVENTS_PATH("events"),
    STORIES_PATH("stories"),
    SERIES_PATH("series")
}

enum class MarvelQueryParam(val value: String) {
    TIMESTAMP("ts"),
    API_KEY("apikey"),
    HASH("hash"),
    NAME_STARTS_WITH("nameStartsWith")
}
