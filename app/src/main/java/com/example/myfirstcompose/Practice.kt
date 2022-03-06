package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.sp

@Composable
fun Greeting(){
    // the main card starts here
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .border(shape = RoundedCornerShape(30.dp), color = Color.White, width = 5.dp)
            .padding(top = 150.dp, bottom = 150.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        // the root column starts here
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(painter = painterResource(id = R.drawable.ifeanyi),
                contentDescription = "Ifeanyi",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 5.dp, shape = CircleShape, color = Color.Red)
            ) // profile image
            Text(text = "Achufusi Ifeanyi",
                fontSize = 13.sp
            ) // profile name
            Text(text = "Android Developer",
                fontWeight = FontWeight.Bold
            ) // Profile occupation

            // row that contains the following, followers, posts etc. BEGIN
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // column for following, followers, posts
                Column() {
                    Text(text = "150")
                    Text(text = "Following", fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text(text = "1500")
                    Text(text = "Following", fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text(text = "3500")
                    Text(text = "Tweets", fontWeight = FontWeight.Bold)
                }
            } // row that contains the following, followers, posts etc. END

            // Row that houses the buttons START
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Buy a Cup of Coffee")
                }
            } // Row that houses the buttons ENDS

        } // the root column ends here

    }  // card ends here
}

@Preview(showBackground = true)
@Composable
fun PreviewUs(){
    Greeting()
}