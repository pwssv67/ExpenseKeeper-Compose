package com.pwssv67.composeplayground.ui.elements.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pwssv67.composeplayground.data.currency.Currency
import com.pwssv67.composeplayground.data.transactions.IncomingTransaction
import com.pwssv67.composeplayground.data.transactions.OutgoingTransaction
import com.pwssv67.composeplayground.data.transactions.Transaction
import com.pwssv67.composeplayground.data.transactions.target.TransactionTarget
import com.pwssv67.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.datetime.Clock
import java.text.DecimalFormat

@Composable
fun Transaction(transaction: Transaction, modifier: Modifier = Modifier) {
    Card(shape = MaterialTheme.shapes.large, backgroundColor = MaterialTheme.colors.surface) {
        Row(
            modifier.padding(16.dp, 24.dp)
        ) {
            Image(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(Modifier.size(16.dp))

            Column(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = transaction.target.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = transaction.target.type, style = MaterialTheme.typography.subtitle2, color = Color.LightGray)
            }

            Spacer(modifier = Modifier.size(16.dp))

            TransactionSum(
                transaction = transaction,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

private val format = DecimalFormat("###,###.##")

@Composable
fun TransactionSum(transaction: Transaction, modifier: Modifier = Modifier) {
    val isIncoming = transaction is IncomingTransaction
    val color = if (isIncoming) Color.Green else Color.White
    val sign = if (isIncoming) "+" else "-"
    val formattedSum = format.format(transaction.sum)
    val text = "$sign${transaction.currency.symbol}$formattedSum"
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle1,
        color = color,
        modifier = modifier
    )
}

private val transaction = OutgoingTransaction(
    100543.25,
    Currency.Dollar,
    Clock.System.now(),
    TransactionTarget(
        "Paypal",
        "Webtech"
    )
)

@Preview(backgroundColor = 0x000000)
@Composable
fun OutgoingPreview() {
    ComposePlaygroundTheme(darkTheme = true) {
        Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            Transaction(
                transaction = transaction, modifier = Modifier
                    .width(480.dp)
                    .wrapContentHeight()
            )
        }
    }
}

private val incomeTransaction = IncomingTransaction(
    100543.25,
    Currency.Dollar,
    Clock.System.now(),
    TransactionTarget(
        "Paypal",
        "Webtech"
    )
)

@Preview(backgroundColor = 0x000000)
@Composable
fun IncomingPreview() {
    ComposePlaygroundTheme(darkTheme = true) {
        Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            Transaction(
                transaction = incomeTransaction, modifier = Modifier
                    .width(480.dp)
                    .wrapContentHeight()
            )
        }
    }
}