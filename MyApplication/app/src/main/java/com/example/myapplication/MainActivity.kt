package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.InterUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI(){
        val factory = InterUtil.provideKalaViewModelStore()
        val viewModel = ViewModelProvider(this, factory).get(KalaViewModel::class.java)
        viewModel.initializeFakeData()

        Log.i("MainActivity", "initializeUI: fetched kala from factory!")
        viewModel.getKalaha().observe(this, Observer {kalaha ->
            kalaha.forEach{kala ->
                Log.i("MainActivity", "initializeUI: $kala")
            }
        })
    }
}