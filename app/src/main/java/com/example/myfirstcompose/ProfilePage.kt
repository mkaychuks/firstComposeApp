package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfilePage(){
    Column {
       Image(painter = painterResource(id = R.drawable.ifeanyi),
           contentDescription = "profile photo") // handles the image
       
       Text(text = "Ifeanyi Achufusi")
       Text(text = "Android Developer")
    } // vertically stack the views on top of each other. MAIN COLUMN
}



@Preview(showBackground = true)
@Composable
fun Preview(){
    ProfilePage()
}