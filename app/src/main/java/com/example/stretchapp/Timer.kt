package com.example.stretchapp
import com.example.stretchapp.MainActivityTimerListener
import android.os.CountDownTimer

class Timer(
        private val mainActivityListener: MainActivityTimerListener,
        private val timeForStretch: Long,
        private val timeForRest: Long) {

    // keeps track of whether we should stop or continue
    private var stretchingSequenceOn: Boolean = false;

    // keep track of stretch and rest timing
    private var stretchTimer: CountDownTimer? = null;
    private var restTimer: CountDownTimer? = null;

    // keep track of cooldown timing
    private var stretchCooldownTimer: CountDownTimer? = null;
    private var restCooldownTimer: CountDownTimer? = null;

    fun stopTimer() : Boolean {

        println("[Timer] stopping Timer entirely")

        // Makes sure the internal state is false
        stretchingSequenceOn = false;

        stretchTimer?.cancel();
        restTimer?.cancel();

        // calls UI updates when the timer stops
        mainActivityListener.onTimerSequenceStopped();

        return true;
    }

    fun startStretchTimer() : Boolean {

        // Makes sure the internal state is true
        stretchingSequenceOn = true;

        // STUB: TODO
        println("[Timer] starting stretch timer.")

        // will time the stretching
        stretchTimer = object : CountDownTimer(timeForStretch * 1000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking stretch timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                stopStretchTimer();
            }
        }
        stretchTimer?.start()

        // Notify listener
        mainActivityListener.onStretchTimerStarted();

        return true;
    }

    fun stopStretchTimer() : Boolean {

        // STUB: TODO
        println("[Timer] stopping stretch timer.")

        // will time the stretch cooldown
        stretchCooldownTimer = object : CountDownTimer(3000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking stretchcooldown timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                startRestTimer();
            }
        }
        stretchCooldownTimer?.start()

        // Notify listener
        mainActivityListener.onStretchTimerStopped();

        return true;
    }

    fun startRestTimer() : Boolean {

        // STUB: TODO
        println("[Timer] starting rest timer.")

        restTimer = object : CountDownTimer(timeForRest * 1000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking rest timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                stopRestTimer();
            }

        }
        restTimer?.start();

        // Notify listener
        mainActivityListener.onRestTimerStarted();

        return true;
    }

    fun stopRestTimer() : Boolean {
        // STUB: TODO
        println("[Timer] stopping rest timer.")

        // will time the stretch cooldown
        restCooldownTimer = object : CountDownTimer(3000, 200) {

            override fun onTick(millisUntilFinished: Long) {
                // TODO("Will need to check if we have to stop")
                if (stretchingSequenceOn) {
                    println("[Timer] ticking restcooldown timer");
                }
                else {
                    this.cancel();
                }
            }

            override fun onFinish() {
                // TODO("Not yet implemented")
                startStretchTimer();
            }
        }
        restCooldownTimer?.start()

        // Notify listener
        mainActivityListener.onRestTimerStopped();

        return true;
    }

}