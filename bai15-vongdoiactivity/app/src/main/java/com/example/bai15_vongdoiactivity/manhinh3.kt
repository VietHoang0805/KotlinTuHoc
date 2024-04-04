package com.example.bai15_vongdoiactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai15_vongdoiactivity.databinding.ActivityManhinh3Binding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityManhinh3Binding
class manhinh3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityManhinh3Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}