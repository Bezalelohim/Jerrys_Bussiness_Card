package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    JerryPage()
                }
            }
        }
    }
}


@Composable
fun ProfilePhotoHandle(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .fillMaxSize()
        .padding(50.dp)
        .padding(horizontal = 40.dp)
        .clip(RoundedCornerShape(30.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.jerry),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 12.dp, top = 10.dp)
                    .clip(RoundedCornerShape(35.dp))

            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(8.dp),
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.jerry_mouse),
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(bottom = 16.dp),
                        color = Color.White
                    )


                    Text(
                        text = stringResource(R.string.cheeseloverjerry), color = Color.White
                    )
                }
            }

        }
    }
}


@Composable
private fun ListElement(
    elementTitle: String,
    elementSubTitle: String,
    elementIcon: Painter,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .background(Color(0XFFFFFCAB))

    )
    {
        Row(modifier = Modifier.size(width = 300.dp, height = 60.dp))
        {
            Icon(
                painter = elementIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterVertically)
            )
            Column {
                Text(
                    text = elementTitle,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(6.dp, bottom = 6.dp)
                )
                Text(
                    text = elementSubTitle,
                    modifier = Modifier.offset(x = 15.dp)
                )
            }
        }
    }
}

@Composable
fun ListOfElements(modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier) {
        ListElement(
            "Jerry ", "Tom's Frenemy",
            painterResource(id = R.drawable.baseline_pest_control_rodent_24)
        )
        ListElement(
            "D.O.B", "When I was born ?",
            painterResource(id = R.drawable.baseline_calendar_month_24)
        )
        ListElement(
            "How Can you meet me ", "cheeseLoverJerry@twitter.com",
            painterResource(id = R.drawable.baseline_handshake_24)
        )
        ListElement(
            "Accomplishments", "Too many to count",
            painterResource(id = R.drawable.baseline_workspace_premium_24)
        )
        ListElement(
            "NetWorth", "More than Tom",
            painterResource(id = R.drawable.baseline_monetization_on_24)
        )
    }
}

@Composable
fun JerryPage() {
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.cheese_background),
            contentDescription = "background cheese",
            contentScale = ContentScale.FillBounds
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            ProfilePhotoHandle(
                modifier = Modifier
                    .weight(0.5f)
                    .wrapContentSize()
            )
            ListOfElements(
                modifier = Modifier
                    .weight(0.5f)
                    .wrapContentSize()
            )
        }


    }
}

@Preview
@Composable

fun PreviewListElement() {
    BusinessCardTheme {
        ListElement(
            "NetWorth", "More than Tom",
            painterResource(id = R.drawable.baseline_monetization_on_24)
        )

    }
}


@Preview
@Composable

fun PreviewProfilePhotoHandle() {
    BusinessCardTheme {
        ProfilePhotoHandle()
    }
}

@Preview
@Composable

fun PreviewJerryPage() {
    BusinessCardTheme {
        JerryPage()
    }
}