package com.example.bai23_kotlin_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai23_kotlin_firebase.databinding.ActivityInsertionBinding

private lateinit var binding: ActivityInsertionBinding
class InsertionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}