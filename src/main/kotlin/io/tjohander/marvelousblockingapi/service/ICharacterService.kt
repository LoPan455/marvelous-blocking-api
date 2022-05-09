package io.tjohander.marvelousblockingapi.service

import io.tjohander.marvelous.model.api.marvel.Character
import io.tjohander.marvelous.model.api.marvel.DataWrapper
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
interface ICharacterService {
    fun getCharacterStartsWith(startsWithString: String): DataWrapper<Character>?
}