package com.example.androiddevchallenge.ui.composable

import android.graphics.BitmapFactory
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy

@Composable
@ExperimentalFoundationApi
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    Scaffold(
        topBar = { PuppyListTopAppBar() }
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            content = {
                items(puppies) { puppy ->
                    PuppyRow(
                        puppy = puppy,
                        onClick = {
                            navController.navigate("puppies/${it.id}")
                        }
                    )
                }
            })
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
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .clickable {
                onClick(puppy)
            }
            .fillMaxWidth()
    ) {
        val inputStream = context.assets.open(puppy.imageFileName)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }
}