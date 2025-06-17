package com.astral.penjadwalankuliah

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                login(username,password)
            }
        }
    }

    private fun login(username: String, password: String) {
        val url = "http://172.22.53.145/jadwal_kuliah/login.php"

        val stringRequest = object : StringRequest(
            Method.POST, url,
            { response ->
                if (response.contains("sukses", ignoreCase = true)) {
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    // lanjut ke activity lain
                    val intent = Intent(this, MenuUtamaActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Login gagal: $response", Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username
                params["password"] = password
                return params
            }
        }

        Volley.newRequestQueue(this).add(stringRequest)
    }
}