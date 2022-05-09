package io.tjohander.marvelousblockingapi.controller

import io.tjohander.marvelousblockingapi.service.ICharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller

@Controller("/characters/v1")
class CharacterController(
    @Qualifier("ICharacterService") @Autowired private val service: ICharacterService
) {
}