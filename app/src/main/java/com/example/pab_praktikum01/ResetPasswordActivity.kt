package com.example.pab_praktikum01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val edtEmail = findViewById<EditText>(R.id.edt_reset_email)
        val btnResetPassword = findViewById<Button>(R.id.btn_reset_password)
        val btnKembaliLogin = findViewById<Button>(R.id.btn_kembali_login)

        btnResetPassword.setOnClickListener {
            val email = edtEmail.text.toString().trim()

            if (email.isEmpty()) {
                edtEmail.error = "Email tidak boleh kosong!"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Link instruksi reset password telah dikirim ke $email", Toast.LENGTH_LONG).show()
            finish()
        }

        btnKembaliLogin.setOnClickListener {
            finish()
        }
    }
}
