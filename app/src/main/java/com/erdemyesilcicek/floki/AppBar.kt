package com.erdemyesilcicek.floki

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.erdemyesilcicek.floki.ui.theme.FlokiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "My Tales",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { println("log out clicked") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = "Log out Button"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { println("menu clicked") }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu Button"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        println(innerPadding)
    }
}


/*
fun AppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                Text(text = "My Tales")
            }
        },
        navigationIcon = {
            IconButton(onClick = { println("log clicked") }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.Logout,
                    contentDescription = "Log Out Button"
                )
            }
        },
        actions = {
            IconButton(onClick = { println("menu clicked") }) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Menu Button"
                )
            }
        }
    )
}

 */

@Preview
@Composable
fun AppBarPreview() {
    FlokiTheme {
        AppBar()
    }
}









