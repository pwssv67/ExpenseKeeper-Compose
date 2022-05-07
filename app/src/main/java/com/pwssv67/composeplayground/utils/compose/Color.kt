package com.pwssv67.composeplayground.utils.compose

import androidx.compose.ui.graphics.Color

fun Color.alpha(value: Float = 1f) = copy(
    alpha = value
)