package com.example.layoutcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

var count: Int = 0;

//Denis Michaud WMAD SR.B

class MainActivity : AppCompatActivity() {

    lateinit var labelCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        labelCount = findViewById(R.id.count_label)


        val countUpButtton: Button = findViewById(R.id.countup_button)
        countUpButtton.setOnClickListener{ countUp()}

        val countDownButtton: Button = findViewById(R.id.countdown_button)
        countDownButtton.setOnClickListener{countDown()}

        val toastButton: Button = findViewById(R.id.toast_button)
        toastButton.setOnClickListener{messageBox()}


    }

    private fun countUp(){
        count ++;
        labelCount.setText(count.toString());

    }
    private fun countDown(){
        count --;
        labelCount.setText(count.toString());
    }

    private fun messageBox(){
        Toast.makeText(applicationContext,"Hello " + count, Toast.LENGTH_SHORT).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.let {
            count = it.get("count") as Int
        }

        labelCount.setText(count.toString())
    }
}