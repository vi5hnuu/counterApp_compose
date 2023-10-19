package com.vi5hnu.introtocompose

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vi5hnu.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        ElevatedCard(modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .border(
                                0.5.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(5.dp)
                            )) {
                            Greeting("Counter", modifier = Modifier
                                .padding(10.dp)
                                .align(CenterHorizontally))
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center) {
                            val counter= remember {
                                mutableStateOf(0)
                            }
                            Card(shape = CircleShape,
                                border = BorderStroke(2.dp,Color.LightGray),
                                modifier = Modifier.size(120.dp)) {
                                    Text(text = "${counter.value}", modifier = Modifier
                                        .fillMaxSize()
                                        .wrapContentSize(Center), fontWeight = FontWeight.Bold, fontSize = 24.sp)
                            }
                            Spacer(modifier = Modifier.height(35.dp))
                            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                                CustomButton(title = "+1", modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)){counter.value++;}
                                CustomButton(title = "-1", modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)){counter.value--;}
                                CustomButton(title = "Reset", modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)){counter.value=0;}
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun CustomButton(title:String,modifier: Modifier=Modifier,onClick:()->Unit) {
        Button(
            shape = RoundedCornerShape(7.dp),
            onClick = { onClick() }) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = modifier
            )
        }
    }
}

@Composable
fun Greeting(message: String, modifier: Modifier = Modifier) {
    Text(
        text = "$message!".uppercase(),
        modifier = modifier,
        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary),
    )
}

