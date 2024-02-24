package com.almland.blockchainimpl

import java.util.UUID

internal fun main() {
    val blockChain = BlockChain()
    val miner = Miner()

    val block0 = Block(UUID.randomUUID(), "", GENESIS_PREV_HASH)
    miner.mine(block0, blockChain)
    println(miner.getReward())

    val block1 = Block(UUID.randomUUID(), "transaction1", blockChain.getLastBlockHash())
    miner.mine(block1, blockChain)
    println(miner.getReward())

    val block2 = Block(UUID.randomUUID(), "transaction2", blockChain.getLastBlockHash())
    miner.mine(block2, blockChain)
    println(miner.getReward())

    println(blockChain)
}
