/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            }
        )
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
