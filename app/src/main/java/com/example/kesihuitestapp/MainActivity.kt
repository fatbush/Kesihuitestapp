package com.example.kesihuitestapp

import MeetingTimeIntervalsChecker
import MeetingTimeIntervalsGenerator
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kesihuitestapp.ui.theme.KesihuiTestAppTheme

class MainActivity : ComponentActivity() {

    private val TAG = this.javaClass.simpleName

    private val checker = MeetingTimeIntervalsChecker()
    private val generator = MeetingTimeIntervalsGenerator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KesihuiTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val intervalsArray = generator.generateTimeArray()
                    val result = checker.check(intervalsArray)
                    if(result!=null){
                        Greeting("The person can attend all meetings?$result")
                    }else{
                        Greeting("intervals arrays error!!")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(hint: String, modifier: Modifier = Modifier) {
    Text(
        text = hint,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KesihuiTestAppTheme {
        Greeting("Android")
    }
}