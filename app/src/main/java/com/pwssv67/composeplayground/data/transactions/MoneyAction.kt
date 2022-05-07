package com.pwssv67.composeplayground.data.transactions

interface MoneyAction {
    val transaction: Transaction
}

data class CardAction(
    val cardNumber: Long, //TODO consider changing to card object
    override val transaction: Transaction
): MoneyAction

data class AccountAction(
    val accountNumber: Long,
    override val transaction: Transaction
): MoneyAction