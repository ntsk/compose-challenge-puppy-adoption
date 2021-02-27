package com.example.androiddevchallenge.ui.composable

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    Column(modifier = Modifier.padding(16.dp)) {
        val inputStream = context.assets.open(puppy.imageFileName)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = puppy.name, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Age: ${puppy.age}", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.Phone, contentDescription = "Ask About Me")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Ask About Me", style = MaterialTheme.typography.subtitle1)
        }
    }
}