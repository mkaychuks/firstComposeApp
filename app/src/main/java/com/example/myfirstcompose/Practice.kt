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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

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
        // the root CONSTRAINT-LAYOUT starts here
        ConstraintLayout{

            val (image, nameText, occupationText, rowStats, buttonCoffee, buttonFollow) = createRefs()
            val guideLine = createGuidelineFromTop(30.dp)



            Image(painter = painterResource(id = R.drawable.ifeanyi),
                contentDescription = "Ifeanyi",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(width = 5.dp, shape = CircleShape, color = Color.Red)
                    .constrainAs(image){
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) // profile image
            Text(text = "Achufusi Ifeanyi",
                fontSize = 13.sp,
                modifier = Modifier.constrainAs(nameText){
                    top.linkTo(image.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) // profile name
            Text(text = "Android Developer",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(occupationText){
                    top.linkTo(nameText.bottom)
                    start.linkTo(nameText.start)
                    end.linkTo(nameText.end)
                }
            ) // Profile occupation

            // row that contains the following, followers, posts etc. BEGIN
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(rowStats){
                        top.linkTo(occupationText.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
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

            Button(onClick = { /*TODO*/ },
                    modifier = Modifier.constrainAs(buttonFollow){
                        start.linkTo(parent.start)
                        end.linkTo(buttonCoffee.start)
                        top.linkTo(rowStats.bottom)
                        width = Dimension.wrapContent
                    }
                ) {
                Text(text = "Follow")
            }
            Button(onClick = { /*TODO*/ },
                    modifier = Modifier.constrainAs(buttonCoffee){
                        start.linkTo(buttonFollow.end)
                        end.linkTo(parent.end)
                        top.linkTo(rowStats.bottom)
                        width = Dimension.wrapContent
                    }
                ) {
                Text(text = "Buy a Cup of Coffee")
            }

        } // the root column ends here

    }  // card ends here
}

@Preview(showBackground = true)
@Composable
fun PreviewUs(){
    Greeting()
}