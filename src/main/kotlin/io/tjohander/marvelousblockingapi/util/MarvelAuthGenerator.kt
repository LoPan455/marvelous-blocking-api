package io.tjohander.marvelous.util

import io.tjohander.marvelous.model.MarvelAuthComponents
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant

class MarvelAuthGenerator {

    companion object {
        fun buildAuthString(
            timeStamp: Instant,
            marvelApiPublicKey: String,
            marvelApiPrivateKey: String
        ): MarvelAuthComponents {
            val preHashString =
                "${timeStamp.toEpochMilli()}$marvelApiPrivateKey$marvelApiPublicKey"
            val hashed: String = DigestUtils.md5Hex(preHashString)
            return MarvelAuthComponents(
                ts = timeStamp.toEpochMilli().toString(),
                publicKey = marvelApiPublicKey,
                md5Hash = hashed
            )
        }
    }

}