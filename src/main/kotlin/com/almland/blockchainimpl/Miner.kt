package com.almland.blockchainimpl

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.RoundingMode.DOWN

internal class Miner {
    private var reward: BigDecimal = ZERO

    // proof of work
    fun mine(block: Block, blockChain: BlockChain) {
        while (isGoldenHash(block).not()) {
            block.incrementNonce()
            block.generateHash()
        }
        println("mined the block: $block\nhash is: ${block.getHash()}")
        blockChain.addBlock(block)
        incrementReward()
    }

    private fun incrementReward() {
        reward = reward.add(REWARD).setScale(2, DOWN)
    }

    private fun isGoldenHash(block: Block): Boolean =
        block.getHash().startsWith(String(CharArray(size = DIFFICULTY) { '0' }))

    fun getReward(): BigDecimal = reward
}