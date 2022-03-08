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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    Card(elevation = 4.dp, modifier = Modifier
        .fillMaxSize()
        .padding()
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ){

        BoxWithConstraints() {
            val constraints = if (minWidth < 600.dp){
                portraitConstraints(margin = 16.dp)
            } else {
                // TODO CALL LANDSCAPE
                landscapeConstraints(margin = 16.dp)
            }

            ConstraintLayout(constraints){

                Image(painter = painterResource(id = R.drawable.ifeanyi),
                    contentDescription = "profile photo",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Red, shape = CircleShape)
                        .padding(
                            top = 16.dp
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                ) // handles the image

                Text(text = "Ifeanyi Achufusi", modifier = Modifier.layoutId("nameText"))
                Text(text = "Android Developer", modifier = Modifier.layoutId("countryText"))

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .layoutId("rowStats"),
                    horizontalArrangement = Arrangement.SpaceEvenly)
                {
                    ProfileStats(title = "Followers", count = "150")
                    ProfileStats(title = "Following", count = "100")
                    ProfileStats(title = "Posts", count = "30")

                } // handles the rows for following, follower, posts

                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonFollow"))
                {
                    Text(text = "Follow User")
                }

                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonMessage"))
                {
                    Text(text = "Direct message")
                }

            } // vertically stack the views on top of each other. MAIN COLUMN

        }

    } // CARD PROFILE
}

// a function that handles duplicated code snippet
@Composable
fun ProfileStats(title: String, count: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}


// constrain-sets for the portrait mode
private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.1f)
        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats){
            top.linkTo(countryText.bottom)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

// constrain-sets for the landscape mode
private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.1f)
        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(image.start)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats){
            top.linkTo(image.top)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom, margin = 16.dp)
            start.linkTo(rowStats.start)
            end.linkTo(buttonMessage.start)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom, margin = 16.dp)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview(){
    ProfilePage()
}