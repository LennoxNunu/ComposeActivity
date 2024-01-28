package com.example.composeactivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeactivity.ui.theme.ComposeActivityTheme

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
                    MyLazyColumn{
                        Toast.makeText(this,it,Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Composable
fun MyLazyColumn(selectedItem: (String)->(Unit)){
    LazyColumn{
      items(count = 100){
          Text(
              text = "User Name $it",
              style = MaterialTheme.typography.h3,
              modifier = Modifier.padding(10.dp)
                  .clickable { selectedItem("$it selected") }
          )
          Divider(color = Color.Black, thickness = 5.dp)
      }
    }
}