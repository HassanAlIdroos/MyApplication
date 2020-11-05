package com.example.ahmed.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {


    lateinit var imgAvengers : ImageView
    lateinit var etPhone: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validNumber="0123456789"
    val validPassword=arrayOf("thanos","hulk","tony")
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"
        imgAvengers = findViewById(R.id.imgAvengers)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)


        btnLogin.setOnClickListener {
            val number=etPhone.text.toString()
            val password=etPassword.text.toString()
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            lateinit var nameOfAvenger: String
            if(number==validNumber){
                when (password) {
                    validPassword[0] -> {

                        nameOfAvenger="The Avengers"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[1] -> {

                        nameOfAvenger="The Hulk"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[2] -> {

                        nameOfAvenger="Iron Man"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                }
            }
            else {
                Toast.makeText(this@LoginActivity,"Wrong Credentials!!",Toast.LENGTH_SHORT).show()
            }
        }
        txtForgotPassword.setOnClickListener {
            val intent=Intent(this@LoginActivity,ForgotPassword::class.java)
            startActivity(intent)
        }
        txtRegister.setOnClickListener {
            val intent=Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("title",title).apply()
    }
}
