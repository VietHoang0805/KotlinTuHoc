package com.example.bai23_kotlin_firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai23_kotlin_firebase.databinding.ActivityMainBinding
import com.example.bai23_kotlin_firebase.ui.theme.Bai23kotlinfirebaseTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsertData.setOnClickListener {
            val intent = Intent(this,InsertionActivity::class.java)
            startActivity(intent)
        }
        binding.btnFetchData.setOnClickListener {
            val intent = Intent(this,FetchingActivity::class.java)
            startActivity(intent)
        }
    }
}
