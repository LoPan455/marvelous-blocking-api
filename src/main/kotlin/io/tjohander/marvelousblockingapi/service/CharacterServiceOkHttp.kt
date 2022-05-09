package io.tjohander.marvelousblockingapi.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.tjohander.marvelous.model.api.marvel.Character
import io.tjohander.marvelous.model.api.marvel.Comic
import io.tjohander.marvelous.model.api.marvel.DataWrapper
import io.tjohander.marvelous.util.MarvelAuthGenerator
import io.tjohander.marvelousblockingapi.enum.MarvelApiUrls
import io.tjohander.marvelousblockingapi.enum.MarvelQueryParam
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.IOException
import java.time.Instant
import java.util.*

@Service
class CharacterServiceOkHttp(
    private val client: OkHttpClient,
    @Value("\${marvel-api.public-key}") val marvelApiPublicKey: String,
    @Value("\${marvel-api.private-key}") val marvelApiPrivateKey: String,
) : ICharacterService {


    override fun getCharacterStartsWith(startsWithString: String): DataWrapper<Character>? {
        val auth = MarvelAuthGenerator.buildAuthString(
            Instant.now(),
            marvelApiPublicKey,
            marvelApiPrivateKey)
        val url = HttpUrl.Builder()
            .scheme(MarvelApiUrls.SCHEME.value)
            .host(MarvelApiUrls.HOST.value)
            .addPathSegment(MarvelApiUrls.API_VERSION.value)
            .addPathSegment(MarvelApiUrls.PUBLIC.value)
            .addPathSegment(MarvelApiUrls.CHARACTER_PATH.value)
            .addQueryParameter(MarvelQueryParam.NAME_STARTS_WITH.value, startsWithString)
            .addQueryParameter(MarvelQueryParam.TIMESTAMP.value, auth.ts)
            .addQueryParameter(MarvelQueryParam.API_KEY.value, auth.publicKey)
            .addQueryParameter(MarvelQueryParam.HASH.value, auth.md5Hash)
            .build()
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Error!: $response")
            println(response.headers().toMultimap().entries)
            val moshi = Moshi.Builder()
                .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .addLast(KotlinJsonAdapterFactory()).build()
            val type = Types.newParameterizedType(DataWrapper::class.java, Character::class.java, Comic::class.java)
            val jsonAdapter: JsonAdapter<DataWrapper<Character>> = moshi.adapter(type)
            return jsonAdapter.fromJson(response.body()!!.string())
        }
    }
}