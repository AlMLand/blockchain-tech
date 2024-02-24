package com.almland.blockchainimpl

import java.math.BigDecimal

// difficulty of mining is defined by the leading zeros
// the more leading zeros are there, the harder to find that given hash
internal const val DIFFICULTY = 2

// this is reward in the underlying cryptocurrency
internal val REWARD = BigDecimal(10)

// first block (genesis)
internal const val GENESIS_PREV_HASH = "0000000000000000000000000000000000000000000000000000000000000000"
