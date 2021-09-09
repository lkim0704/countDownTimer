package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var stopWatch : Chronometer
    lateinit var startStop : Button
    lateinit var reset : Button
    var stopTime: Long = 0

    companion object {
        val TAG ="MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        var check : Boolean = true
        startStop.text = "Start/Stop"

        startStop.setOnClickListener {
            stopStart(check)
            check = !check
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    fun wireWidgets(){
        stopWatch = findViewById(R.id.chronometer_main_stopwatch)
        startStop = findViewById(R.id.button_main_startStop)
        reset = findViewById(R.id.button_main_reset)
    }

    fun stopStart(check : Boolean){
        if(check){
            stopWatch.setBase(SystemClock.elapsedRealtime() + stopTime)
            stopWatch.start()
            startStop.text = "Stop"
        }
        else {
            stopWatch.setBase()
            stopWatch.stop()
            startStop.text = "Start"
        }
    }
}