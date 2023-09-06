package com.example.tutorielandroidstudiogoogle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorielandroidstudiogoogle.ui.theme.TutorielAndroidStudioGoogleTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorielAndroidStudioGoogleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // BirthdayCardPreview() // 1er tutoriel
                    DiceRollerApp() // 2ème tuto

                }
            }
        }
    }
}

//----------------------- 1er tutoriel -----------------------//

@Composable
fun GreetingText(message: String,from: String,modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(15.dp)) {

    Text(
        text = message,
        fontSize = 80.sp,
        lineHeight = 70.sp,
        textAlign = TextAlign.Center

    )
    Text(
        text = from,
        fontSize = 36.sp,
        modifier = Modifier
            .padding(16.dp)
        .align(alignment = Alignment.End)

        )
    }
}
//@Preview(showBackground = true, name = "NamePreview", showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    TutorielAndroidStudioGoogleTheme {
        GreetingText("Happy Birthday Max","from yakup")
    }
}
//------------------------------------------------------------//

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()

}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier,  horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageResource), contentDescription = result.toString())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}