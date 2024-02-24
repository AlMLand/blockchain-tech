package com.almland.sha256algorithm

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

private fun main() {
    println(Sha256Algorithm.hash("alex"))
}

private const val BITCOIN_HASH_PREFIX = "000000000000000000"

private object Sha256Algorithm {
    @OptIn(ExperimentalStdlibApi::class)
    fun hash(input: String): String {
        var hash = ""
        var wishedInput = input
        var nonce = 0
        while (isGoldenHash(hash)) {
            try {
                hash = MessageDigest.getInstance("SHA-256").let { messageDigest ->
                    messageDigest.digest(wishedInput.toByteArray(UTF_8)).let {
                        StringBuffer()
                            .apply { it.iterator().forEach { append(it.toHexString()) } }
                            .toString()

                    }
                }
            } catch (e: Exception) {
                throw RuntimeException("something is wrong")
            }
            wishedInput += nonce++
        }
        println("nonce: $nonce")
        return hash
    }

    private fun isGoldenHash(hash: String): Boolean = hash.startsWith(BITCOIN_HASH_PREFIX).not()
}
