package com.roman_kulikov.myfittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.roman_kulikov.myfittracker.navigation.Navigator
import com.roman_kulikov.myfittracker.ui.theme.MyFitTrackerTheme
import com.roman_kulikov.myfittracker.ui.theme.composables.MainContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainContainer {
                Navigator()
            }
        }
    }
}