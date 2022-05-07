package com.pwssv67.composeplayground.data.transactions

import com.pwssv67.composeplayground.data.currency.Currency
import com.pwssv67.composeplayground.data.transactions.target.TransactionTarget
import kotlinx.datetime.Instant

sealed interface Transaction {
    val sum: Double
    val currency: Currency
    val date: Instant
    val target: TransactionTarget
}

data class OutgoingTransaction(
    override val sum: Double,
    override val currency: Currency,
    override val date: Instant,
    override val target: TransactionTarget
) : Transaction

data class IncomingTransaction(
    override val sum: Double,
    override val currency: Currency,
    override val date: Instant,
    override val target: TransactionTarget
) : Transaction
