package com.example.ahmed.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    lateinit var btnRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegister=findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}