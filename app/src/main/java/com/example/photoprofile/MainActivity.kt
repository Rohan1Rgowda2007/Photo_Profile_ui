package com.example.photoprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photoprofile.ui.theme.PhotoProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoProfileTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray,
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            ProfileCard()
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .heightIn(120.dp)
            .padding(13.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            PhotoProfile()
            ProfileContent()
        }
    }
}

@Composable
fun PhotoProfile() {

    val size = 59.dp

    Card(
        modifier = Modifier
            .padding(start = 18.dp, top = 19.dp, bottom = 20.dp)
            .size(size),
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Green
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "Image",
            modifier = Modifier
                .size(size)
              ,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .padding(start = 44.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rohan.R",
            fontSize = 22.sp,
            fontStyle = MaterialTheme.typography.h5.fontStyle
        )

        Spacer(modifier = Modifier.padding(1.dp))

        Text(
            text = "Active now",
            modifier = Modifier
                .alpha(alpha = 0.6f)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PhotoProfileTheme {
        MainScreen()
    }
}
