package com.example.composeactivity

sealed class UIEvent{
    data class ShowMessage(val message:String):UIEvent()
}