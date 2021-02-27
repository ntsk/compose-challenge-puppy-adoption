package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    Scaffold(
        topBar = { PuppyListTopAppBar() }
    ) {
        LazyColumn {
            items(puppies) { puppy ->
                PuppyRow(
                    puppy = puppy,
                    onClick = {
                        navController.navigate("puppies/${it.id}")
                    }
                )
                Divider(modifier = Modifier.height(1.dp))
            }
        }
    }
}

@Composable
fun PuppyListTopAppBar() {
    TopAppBar(
        title = { Text("Puppies") }
    )
}

@Composable
fun PuppyRow(puppy: Puppy, onClick: (Puppy) -> Unit) {
    Row(
        modifier = Modifier
            .clickable {
                onClick(puppy)
            }
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = puppy.name, style = MaterialTheme.typography.h5)
    }
}