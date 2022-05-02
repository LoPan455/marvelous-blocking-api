package io.tjohander.marvelousblockingapi.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.tjohander.marvelous.model.api.marvel.Character
import io.tjohander.marvelous.model.api.marvel.DataWrapper
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Configuration
class WebConfig {

    @Bean("client")
    fun client(): OkHttpClient = OkHttpClient()

    @Bean("mapper")
    fun mapper(): ObjectMapper = ObjectMapper()
        .findAndRegisterModules()
        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
        .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)

//    @Bean("characterAdapater")
//    fun characterAdapter(): JsonAdapter<DataWrapper<Character>> {
//        val moshi: Moshi = Moshi.Builder()
//            .addLast(KotlinJsonAdapterFactory())
//            .build()
//    }
}