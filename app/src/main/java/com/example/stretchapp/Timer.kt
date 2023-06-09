package com.example.stretchapp
import com.example.stretchapp.MainActivityTimerListener

class Timer(private val mainActivityListener: MainActivityTimerListener) {

    fun startStretchTimer() : Boolean {

        // STUB: TODO
        println("[starting] stretch timer.")

        // Notify listener
        mainActivityListener.onStretchTimerStarted();

        return true;
    }

    fun stopStretchTimer() : Boolean {

        // STUB: TODO
        println("[stopping] stretch timer.")

        // Notify listener
        mainActivityListener.onStretchTimerStopped();

        return true;
    }

    fun startRestTimer() : Boolean {

        // STUB: TODO
        println("[starting] rest timer.")

        // Notify listener
        mainActivityListener.onRestTimerStarted();

        return true;
    }

    fun stopRestTimer() : Boolean {

        // STUB: TODO
        println("[stopping] rest timer.")

        // Notify listener
        mainActivityListener.onRestTimerStopped();

        return true;
    }

}