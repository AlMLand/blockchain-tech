package com.almland.blockchainimpl

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

internal object Sha256Algorithm {

    private const val ALGORITHM = "SHA-256"

    @OptIn(ExperimentalStdlibApi::class)
    fun generateHash(blockData: String): String =
        try {
            val messageDigest = MessageDigest.getInstance(ALGORITHM)
            val byteArray = messageDigest.digest(blockData.toByteArray(UTF_8))
            StringBuilder()
                .apply { byteArray.iterator().forEach { append(it.toHexString()) } }
                .toString()
        } catch (e: Exception) {
            throw RuntimeException("something is wrong: $e")
        }
}
