package com.roman_kulikov.myfittracker.ui.theme.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.roman_kulikov.myfittracker.ui.theme.MyFitTrackerTheme

@Composable
fun MainContainer(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    MyFitTrackerTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = modifier.statusBarsPadding().padding(paddingValues),
                content = content,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment
            )
        }
    }
}