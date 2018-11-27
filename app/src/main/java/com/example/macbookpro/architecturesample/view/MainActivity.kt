package com.example.macbookpro.architecturesample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.macbookpro.architecturesample.R
import com.example.macbookpro.architecturesample.model.Board

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val board = Board()
    }
}