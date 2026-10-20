package com.example.pab_praktikum01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edt_login_email)
        val edtPassword = findViewById<EditText>(R.id.edt_login_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val tvLupaPassword = findViewById<TextView>(R.id.tv_lupa_password)
        val tvToRegister = findViewById<TextView>(R.id.tv_to_register)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isEmpty()) {
                edtEmail.error = "Email/Username tidak boleh kosong!"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                edtPassword.error = "Password tidak boleh kosong!"
                edtPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Login Berhasil! Selamat Datang.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        tvToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        tvLupaPassword.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }
}
