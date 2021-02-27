package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyDetail(puppy: Puppy, navController: NavController) {
    Scaffold(
        topBar = {
            PuppyDetailTopAppBar(
                puppyName = puppy.name,
                onBackButtonClick = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        PuppyDetailContent(puppy)
    }
}

@Composable
fun PuppyDetailTopAppBar(puppyName: String, onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(puppyName) },
        navigationIcon = {
            IconButton(onClick = { onBackButtonClick() })
            { Icon(Icons.Filled.ArrowBack, contentDescription = "Back") }
        },
    )
}

@Composable
fun PuppyDetailContent(puppy: Puppy) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = puppy.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Age: ${puppy.age}", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
    }
}