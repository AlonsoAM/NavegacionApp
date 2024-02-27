package com.example.navegacionapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacionapp.components.ActionButton
import com.example.navegacionapp.components.MainButton
import com.example.navegacionapp.components.Space
import com.example.navegacionapp.components.TitleBar
import com.example.navegacionapp.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar(name = "Home View") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Red
            )
        )
    }, floatingActionButton = {
        ActionButton()
    }) {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()
        TextField(value = opcional, onValueChange = { opcional = it }, label = { Text("Opcional") })
        Space()
        MainButton(name = "Detail View", backColor = Color.Red, color = Color.White) {
            navController.navigate("detail/${id}/?${opcional}")
        }
    }
}