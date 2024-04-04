package com.example.bai15_vongdoiactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.bai15_vongdoiactivity.databinding.ActivityManhinh2Binding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityManhinh2Binding
class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khời tạo view binding
        binding = ActivityManhinh2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}