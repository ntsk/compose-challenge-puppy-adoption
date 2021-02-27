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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
            IconButton(onClick = { onBackButtonClick() }) { Icon(Icons.Filled.ArrowBack, contentDescription = "Back") }
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
