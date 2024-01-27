package com.example.composeactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.composeactivity.ui.theme.ComposeActivityTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplaySnackBar()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun DisplaySnackBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
              val snackBarResult =  scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is a message",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Long
                )

                when(snackBarResult){
                    SnackbarResult.ActionPerformed -> Log.i("MyTag","action label clicked")
                    SnackbarResult.Dismissed -> Log.i("MyTag","Dismissed!")
                }
            }
        }) {
            Text(text = "Display a SnackBar")
        }
    }

}