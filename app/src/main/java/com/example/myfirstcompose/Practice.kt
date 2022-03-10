package com.example.myfirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
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
        BoxWithConstraints {
            val constraints = portraitModeConstraint(margin = 16.dp)

            // the root CONSTRAINT-LAYOUT starts here
            ConstraintLayout(constraints){
                Image(painter = painterResource(id = R.drawable.ifeanyi),
                    contentDescription = "Ifeanyi",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(width = 5.dp, shape = CircleShape, color = Color.Red)
                        .layoutId("image")
                ) // profile image
                Text(text = "Achufusi Ifeanyi",
                    fontSize = 13.sp,
                    modifier = Modifier.layoutId("nameText")
                ) // profile name
                Text(text = "Android Developer",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId("occupationText")
                ) // Profile occupation

                // row that contains the following, followers, posts etc. BEGIN
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
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
                    modifier = Modifier.layoutId("buttonFollow")
                ) {
                    Text(text = "Follow")
                }
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.layoutId("buttonCoffee")
                ) {
                    Text(text = "Buy a Cup of Coffee")
                }

            } // the root column ends here
        }

    }  // card ends here
}


// constraint set for portrait mode
private fun portraitModeConstraint(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val occupationText = createRefFor("occupationText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonCoffee = createRefFor("buttonCoffee")
        val guideLine = createGuidelineFromTop(0.1f)

        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(nameText){
            top.linkTo(image.bottom, margin = 8.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(occupationText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }

        constrain(rowStats){
            top.linkTo(occupationText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(buttonFollow){
            start.linkTo(parent.start)
            end.linkTo(buttonCoffee.start)
            top.linkTo(rowStats.bottom)
            width = Dimension.wrapContent
        }

        constrain(buttonCoffee){
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            top.linkTo(rowStats.bottom)
            width = Dimension.wrapContent
        }
    }
}



@Composable
fun statelessManagement(){
    var nameState by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello")
        Spacer(modifier = Modifier.height(8.dp))

        TextField(value = nameState, onValueChange = {
                nameState = it
        })

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Display")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUs(){
    //Greeting()
    statelessManagement()
}