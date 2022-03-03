package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
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
            modifier = Modifier.fillMaxSize(),
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

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
             ProfileStats(title = "Followers", count = "150")
             ProfileStats(title = "Following", count = "100")
             ProfileStats(title = "Posts", count = "30")

        } // handles the rows for following, follower, posts

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Follow User")
            }
            
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Direct message")
            }

        } // HANDLES THE BUTTONS

    } // vertically stack the views on top of each other. MAIN COLUMN
}

// a function that handles duplicated code snippet
@Composable
fun ProfileStats(title: String, count: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}


@Preview(showBackground = true)
@Composable
fun Preview(){
    ProfilePage()
}