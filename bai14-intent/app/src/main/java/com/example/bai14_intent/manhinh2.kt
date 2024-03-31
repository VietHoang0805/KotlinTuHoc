package com.example.bai14_intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai14_intent.databinding.ActivityManhinh2Binding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityManhinh2Binding
class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Binding
        binding = ActivityManhinh2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}