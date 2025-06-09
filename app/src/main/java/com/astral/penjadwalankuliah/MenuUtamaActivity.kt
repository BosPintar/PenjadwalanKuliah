package com.astral.penjadwalankuliah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.astral.penjadwalankuliah.databinding.ActivityMenuUtamaBinding

class MenuUtamaActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuUtamaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtNama.text = intent.getStringExtra("nama")
    }
}