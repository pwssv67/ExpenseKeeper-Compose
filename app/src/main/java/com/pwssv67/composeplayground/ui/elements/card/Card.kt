package com.pwssv67.composeplayground.ui.elements.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pwssv67.composeplayground.R
import com.pwssv67.composeplayground.ui.theme.ComposePlaygroundTheme
import com.pwssv67.composeplayground.utils.compose.alpha
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun BasicCard(
    number: Long,
    holder: String,
    expireMonth: Int,
    expireYear: Int,
    cardSystem: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_outline_chip_24),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically),
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = cardSystem,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = cardFormatter.format(number),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onPrimary,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(2f))

        Row(Modifier.fillMaxWidth()) {
            Column {
                Text(
                    text = stringResource(id = R.string.card_holder).uppercase(),
                    style = MaterialTheme.typography.caption,
                    color = Color.LightGray.alpha(0.9f)
                )
                Text(
                    text = holder,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    text = stringResource(id = R.string.expiry_date),
                    style = MaterialTheme.typography.caption,
                    color = Color.LightGray.alpha(0.9f)
                )
                Text(
                    text = "$expireMonth/$expireYear",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

private val cardFormatter = DecimalFormat("####,####").apply {
    decimalFormatSymbols = DecimalFormatSymbols().apply {
        groupingSeparator = ' '
    }
}

@Preview
@Composable
fun Preview() {
    ComposePlaygroundTheme(darkTheme = true) {
        BasicCard(
            number = 4562112245957852,
            holder = "Test Test",
            expireMonth = 12,
            expireYear = 2022,
            cardSystem = "VISA",
            modifier = Modifier
                .width(400.dp)
                .aspectRatio(16f / 9f)
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.medium
                )
        )
    }
}