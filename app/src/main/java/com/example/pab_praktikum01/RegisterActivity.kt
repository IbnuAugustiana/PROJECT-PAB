package com.example.pab_praktikum01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val edtNama = findViewById<EditText>(R.id.edt_reg_nama)
        val edtEmail = findViewById<EditText>(R.id.edt_reg_email)
        val edtPassword = findViewById<EditText>(R.id.edt_reg_password)
        val edtConfirmPassword = findViewById<EditText>(R.id.edt_reg_confirm_password)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val tvToLogin = findViewById<TextView>(R.id.tv_to_login)

        btnRegister.setOnClickListener {
            val nama = edtNama.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()
            val confirmPassword = edtConfirmPassword.text.toString().trim()

            if (nama.isEmpty()) {
                edtNama.error = "Nama lengkap tidak boleh kosong!"
                edtNama.requestFocus()
                return@setOnClickListener
            }

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

            if (password.length < 6) {
                edtPassword.error = "Password minimal 6 karakter!"
                edtPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                edtConfirmPassword.error = "Password dan Konfirmasi Password tidak cocok!"
                edtConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()
            finish()
        }

        tvToLogin.setOnClickListener {
            finish()
        }
    }
}
