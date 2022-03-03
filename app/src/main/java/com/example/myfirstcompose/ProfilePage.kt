package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        )
    {
       Image(painter = painterResource(id = R.drawable.ifeanyi),
           contentDescription = "profile photo",
           modifier = Modifier
               .size(100.dp)
               .clip(CircleShape)
               .border(width = 2.dp, color = Color.Red, shape = CircleShape),
           contentScale = ContentScale.Crop
           ) // handles the image
       
       Text(text = "Ifeanyi Achufusi")
       Text(text = "Android Developer")

        Row (modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "150", fontWeight = FontWeight.Bold)
                Text(text = "Followers")
            } // handles the different columns in the row

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "100", fontWeight = FontWeight.Bold)
                Text(text = "Following")
            } // handles the different columns in the row

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "300", fontWeight = FontWeight.Bold)
                Text(text = "Posts")
            } // handles the different columns in the row

        } // handles the rows for following, follower, posts

    } // vertically stack the views on top of each other. MAIN COLUMN
}


@Preview(showBackground = true)
@Composable
fun Preview(){
    ProfilePage()
}