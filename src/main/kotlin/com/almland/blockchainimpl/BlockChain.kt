package com.almland.blockchainimpl

import java.util.LinkedList

internal class BlockChain {
    // immutable ledger, not able to remove blocks
    private val blockChain: MutableList<Block> = LinkedList<Block>()

    fun addBlock(block: Block): Boolean = blockChain.add(block)

    // prevent for deletions get immutable blockchain list
    fun getBlockChain(): List<Block> = blockChain.toList()

    fun getLastBlockHash(): String = blockChain.last().getHash()

    override fun toString(): String = "BlockChain(blockChain=\n${blockChain.joinToString("\n")}\n)"
}
