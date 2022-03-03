package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
       Image(painter = painterResource(id = R.drawable.ifeanyi),
           contentDescription = "profile photo",
           modifier = Modifier.size(100.dp)
               .clip(CircleShape)
               .border(width = 2.dp, color = Color.Red, shape = CircleShape),
           contentScale = ContentScale.Crop
           ) // handles the image
       
       Text(text = "Ifeanyi Achufusi")
       Text(text = "Android Developer")
    } // vertically stack the views on top of each other. MAIN COLUMN
}



@Preview(showBackground = true)
@Composable
fun Preview(){
    ProfilePage()
}