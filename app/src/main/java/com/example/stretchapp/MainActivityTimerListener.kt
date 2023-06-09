package com.example.stretchapp

interface MainActivityTimerListener {
    fun onStretchTimerStarted()
    fun onStretchTimerStopped()
    fun onRestTimerStarted()
    fun onRestTimerStopped()
}