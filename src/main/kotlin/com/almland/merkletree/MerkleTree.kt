package com.almland.merkletree

internal class MerkleTree(private val transactions: List<String>) {

    fun getMerkeRoot(): String = constructMerkleRoot(transactions).first()

    private fun constructMerkleRoot(transactions: List<String>): List<String> =
        if (transactions.size == 1) transactions
        else mutableListOf<String>().apply {
            (transactions.indices step 2).asIterable().forEach {
                if (isLastIndex(it, transactions)) add(mergeHash(transactions[it], transactions[it]))
                else add(mergeHash(transactions[it], transactions[it + 1]))
            }
        }.let { constructMerkleRoot(it) }

    private fun isLastIndex(index: Int, transactions: List<String>): Boolean = index == transactions.size - 1

    private fun mergeHash(hash1: String, hash2: String): String = CryptographyHelper.generateHash("$hash1$hash2")
}
