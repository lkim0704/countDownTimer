package com.example.countdowntimer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
        reset.text = "Reset"
        reset.setBackgroundColor(Color.BLACK)


        startStop.setOnClickListener {
            stopStart(check)
            check = !check
        }

        reset.setOnClickListener {
            resetTime()
            check = true
        }

    }

    fun wireWidgets(){
        stopWatch = findViewById(R.id.chronometer_main_stopwatch)
        startStop = findViewById(R.id.button_main_startStop)
        reset = findViewById(R.id.button_main_reset)
    }

    fun stopStart(check : Boolean){
        if(check){
            stopWatch.setBase(SystemClock.elapsedRealtime() - stopTime)
            stopWatch.start()
            startStop.text = "Stop"
            startStop.setBackgroundColor(Color.RED)
        }
        else {
            stopTime = SystemClock.elapsedRealtime() - stopWatch.getBase()
            stopWatch.stop()
            startStop.text = "Start"
            startStop.setBackgroundColor(Color.rgb(92,0,224))
        }
    }

    fun resetTime(){
        stopWatch.setBase(SystemClock.elapsedRealtime())
        stopWatch.stop()
        stopStart(false)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}