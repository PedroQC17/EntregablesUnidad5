package com.example.ejercicios_unidad_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardPrincipal(
    name: String,
    description: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFF006C4C), CircleShape)
                .border(1.dp, Color(0xF0131111), CircleShape)
        )
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp)
        )

        Text(
            text = description,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun CardDetails(
    number: String,
    username: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        CardDetailItem(
            icon = R.drawable.search_24dp_1f1f1f,
            text = number
        )

        CardDetailItem(
            icon = R.drawable.account_circle_24dp_1f1f1f,
            text = username
        )

        CardDetailItem(
            icon = R.drawable.home_24dp_1f1f1f,
            text = email
        )
    }
}

@Composable
fun CardDetailItem(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color(0xFF006C4C),
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp),
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardPrincipal(
            name = "Pedro Quincho",
            description = "Primera app en Android Studio",
            image = painterResource(R.drawable.android_logo),
            modifier = Modifier.padding(top = 150.dp)
        )

        CardDetails(
            number = "+1 (123) 444 555 666",
            username = "@AndroidDev",
            email = "oder.quincho@unmsm.edu.pe"
        )
    }
}

@Composable
fun BusinessCardScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFA4DA7E)
    ) {
        BusinessCard(
            modifier = Modifier.background(Color(0xFFA4DA7E))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCardScreen()
    }
}