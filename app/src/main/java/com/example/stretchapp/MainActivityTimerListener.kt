package com.example.stretchapp

interface MainActivityTimerListener {
    fun onTimerSequenceStopped();
    fun onStretchTimerStarted();
    fun onStretchTimerStopped();
    fun onRestTimerStarted();
    fun onRestTimerStopped();
}