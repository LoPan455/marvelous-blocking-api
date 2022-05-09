package io.tjohander.marvelousblockingapi

import io.tjohander.marvelousblockingapi.service.ICharacterService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ApplicationCommandLineRunner(
    val characterService: ICharacterService,
) : CommandLineRunner {


    override fun run(vararg args: String?): Unit {
        val characterResult = characterService.getCharacterStartsWith("Magneto")
        println(characterResult?.data?.results?.first().toString())
    }
}