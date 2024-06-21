package com.example.brailleboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.brailleboard.ui.theme.BrailleBoardTheme
import com.example.brailleboard.ui.theme.Yellow
import com.example.brailleboard.utils.Utils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Utils.hideStatusBar(this)

        setContent {
            BrailleBoardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                    ) {
                        Welcome()
                    }

                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth().padding(bottom = 64.dp),
                            painter = painterResource(id = R.drawable.ic_login_page),
                            contentDescription = "Login Page",

                            )
                        HelloText()
                    }


                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoginButton(this@MainActivity)
                    }
                }
            }
        }
    }
}

@Composable
fun Welcome() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 40.dp))
            .background(Yellow)
    ) {
        Text(
            text = stringResource(R.string.welcome),
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
        )
    }
}

@Composable
fun HelloText() {
    Text(
        modifier = Modifier.padding(bottom = 64.dp),
        text = stringResource(R.string.hello_text),
        color = Color.White,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 20.sp)
    )
}

@Composable
fun LottieAnimation() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.yellow_animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    com.airbnb.lottie.compose.LottieAnimation(
        composition = composition,
        progress = {
            progress
        }
    )
}

@Composable
fun LoginButton(componentActivity:ComponentActivity) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                componentActivity.startActivity(Intent(componentActivity, RegisterActivity::class.java))
            },
        painter = painterResource(id = R.drawable.ic_login),
        contentDescription = "Login",

        )
}