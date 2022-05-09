package io.tjohander.marvelousblockingapi.controller

import io.tjohander.marvelousblockingapi.service.ICharacterService
import org.springframework.stereotype.Controller

@Controller("/characters/v1")
class CharacterController(
    private val service: ICharacterService
) {
}