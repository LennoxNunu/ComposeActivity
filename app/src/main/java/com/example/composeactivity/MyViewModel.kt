package com.example.composeactivity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    val myFlow = flow<Int>{
        for (i in 1..100){
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo(){
        val myFlow1 = flow<Int> {
            for (i in 1..10){
                Log.i("MYTAG","Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        viewModelScope.launch {
            // myFlow1.collect {
            // myFlow1.buffer().collect {
             myFlow1.collectLatest {
                delay(2000L)
                Log.i("MYTAG","Consumed $it")
            }
        }
    }

}