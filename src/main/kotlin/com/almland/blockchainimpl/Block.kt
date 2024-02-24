package com.almland.blockchainimpl

import java.time.ZonedDateTime
import java.util.UUID

internal class Block(
    private val id: UUID,
    private val transaction: String,
    private val previousHash: String
) {
    private var nonce: Int = 0
    private val timeStamp: Long = ZonedDateTime.now().toEpochSecond()
    private lateinit var hash: String

    init {
        generateHash()
    }

    fun incrementNonce() {
        nonce = nonce.inc()
    }

    fun generateHash() {
        val blockData = "$id$transaction$previousHash$timeStamp$nonce"
        hash = Sha256Algorithm.generateHash(blockData)
    }

    fun getId(): UUID = id
    fun getNonce(): Int = nonce
    fun getHash(): String = hash
    fun getTimeStamp(): Long = timeStamp
    fun getTransaction(): String = transaction
    fun getPreviousHash(): String = previousHash

    override fun toString(): String =
        "Block(id=$id, transaction='$transaction', previousHash='$previousHash', nonce=$nonce, " +
                "timeStamp=$timeStamp, hash='$hash')"
}
