package com.example.ahmed.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var btnLogout:Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        titleName=sharedPreferences.getString("title","The Avengers")
        title = titleName
        btnLogout=findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }
}
