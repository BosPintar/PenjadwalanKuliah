package com.astral.penjadwalankuliah

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.astral.penjadwalankuliah.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btLogin.setOnClickListener {
            val username = binding.edUsername.text.toString()
            val password = binding.edPass.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                // Kalau username atau password kosong
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (username == "admin" && password == "12345") {
                // Kalau username dan password benar pindah form
                val intent = Intent(this, MenuUtamaActivity::class.java)
                startActivity(intent)
            } else {
                // Kalau username atau password salah muncul pesan
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }

        }

    }
}