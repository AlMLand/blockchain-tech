package com.almland.merkletree

internal fun main() {
    val tr = listOf("a", "b", "c")
    val m1 = MerkleTree(tr).getMerkeRoot()
    val m2 = CryptographyHelper.generateHash(
        CryptographyHelper.generateHash("ab") + CryptographyHelper.generateHash("cc")
    )
    println(m1 == m2)
}
