package com.example.unscramble.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    secondary = LightBlue,
    tertiary = DarkGray
)

object CustomTheme {
    val space: CustomSpace
        @Composable
        @ReadOnlyComposable
        get() = LocalSpace.current

    val shape: CustomShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current

    val textSize: CustomTextSize
        @Composable
        @ReadOnlyComposable
        get() = LocalTextSize.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val color: CustomColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

}


val LocalSpace = staticCompositionLocalOf { CustomSpace() }
val LocalTextSize = staticCompositionLocalOf { CustomTextSize() }
val LocalTypography = staticCompositionLocalOf { CustomTypography() }
val LocalColor = staticCompositionLocalOf { CustomColor() }
val LocalShape = staticCompositionLocalOf { CustomShape() }

data class CustomSpace(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)

data class CustomTextSize(
    val small: TextUnit = 4.sp,
    val medium: TextUnit = 8.sp,
    val large: TextUnit = 16.sp,
    val extraLarge: TextUnit = 32.sp,
)

data class CustomTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = CustomTextSize().extraLarge,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = CustomTextSize().large,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    val label: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = CustomTextSize().medium,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)

data class CustomColor(
    val primary: Color = LightColorScheme.primary,
    val secondary: Color = LightColorScheme.secondary,
    val tertiary: Color = LightColorScheme.tertiary,
)

data class CustomShape(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,
)

@Composable
fun CustomTheme(
    space: CustomSpace = CustomTheme.space,
    shape: CustomShape = CustomTheme.shape,
    textSize: CustomTextSize = CustomTheme.textSize,
    typography: CustomTypography = CustomTheme.typography,
    color: CustomColor = CustomTheme.color,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSpace provides space,
        LocalShape provides shape,
        LocalTextSize provides textSize,
        LocalTypography provides typography,
        LocalColor provides color
    ) {
        content()
    }
}