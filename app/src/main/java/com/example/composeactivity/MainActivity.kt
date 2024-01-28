package com.example.composeactivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeactivity.compose.TvShowListItem
import com.example.composeactivity.data.TvShowList
import com.example.composeactivity.model.TvShow
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
                    DisplayTvShows{
                        startActivity(InfoActivity.intent(this,it))
                    }
                }
            }
        }
    }
}


@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> (Unit)){
    val tvShows = remember{TvShowList.tvShows}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        items(items = tvShows , itemContent = {
            TvShowListItem(tvShow = it, selectedItem = selectedItem)
        })
    }
}


