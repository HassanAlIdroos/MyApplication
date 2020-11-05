package com.example.ahmed.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class ForgotPassword: AppCompatActivity() {
    lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        title = "Forgot Password?"
        btnSubmit=findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
         finish()
    }
}