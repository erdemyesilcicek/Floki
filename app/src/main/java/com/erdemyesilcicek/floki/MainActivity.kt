package com.erdemyesilcicek.floki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erdemyesilcicek.floki.ui.theme.FlokiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlokiTheme {
                MyTalesScreen()
            }
        }
    }
}



@Preview
@Composable
fun MyTalesScreen() {
    Scaffold(
        topBar = { AppBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Card()
            Card()
            Card()
            Card()
        }
    }
}


/*
@Composable
fun MyTalesScreen() {
    Scaffold(
        topBar = { AppBar() },
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Card()
            Card()
            Card()
            Card()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlokiTheme {
        MyTalesScreen()
    }
}

 */