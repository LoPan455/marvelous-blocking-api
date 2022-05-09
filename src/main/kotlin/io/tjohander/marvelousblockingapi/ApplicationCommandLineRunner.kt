package io.tjohander.marvelousblockingapi

import io.tjohander.marvelousblockingapi.service.CharacterServiceOkHttp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ApplicationCommandLineRunner(
    @Autowired val characterService: CharacterServiceOkHttp
) : CommandLineRunner {

    override fun run(vararg args: String?): Unit {
        characterService.getCharacterByStartsWith("Magneto")
    }
}