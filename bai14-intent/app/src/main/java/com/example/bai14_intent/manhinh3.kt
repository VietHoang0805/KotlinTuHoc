package com.example.bai14_intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai14_intent.databinding.ActivityManhinh3Binding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityManhinh3Binding
class manhinh3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo binding
        binding = ActivityManhinh3Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}