package com.wsa.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorContainer(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 16.dp,
    indicatorHeight: Dp = 40.dp,
    containerColor: Color = Color.White,
    indicatorColor: Color = Color(0xFF6200EA),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = containerColor,
                    shape = RoundedCornerShape(cornerRadius)
                )
                .border(
                    width = borderWidth,
                    color = Color.Black,
                    shape = RoundedCornerShape(cornerRadius)
                )
                .padding(contentPadding)
        ) {
            content()
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(indicatorHeight)
                .height(indicatorHeight)
                .offset(y = (indicatorHeight / 2))
                .background(
                    color = indicatorColor,
                    shape = RoundedCornerShape(50) // Creates oval shape
                )
                .border(
                    width = borderWidth,
                    color = Color.Black,
                    shape = RoundedCornerShape(50)
                )
        )
    }
}

@Preview
@Composable
fun IndicatorContainerPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Example 1: Basic usage
        IndicatorContainer {
            Text(
                text = "This is a beautiful container with content inside!",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }

        // Example 2: Custom styling
        IndicatorContainer(
            borderWidth = 4.dp,
            cornerRadius = 24.dp,
            indicatorHeight = 50.dp,
            containerColor = Color(0xFFF5F5F5),
            indicatorColor = Color(0xFF6200EA),
            contentPadding = PaddingValues(24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Custom Styled Container",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "With multiple lines of content and custom colors",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}