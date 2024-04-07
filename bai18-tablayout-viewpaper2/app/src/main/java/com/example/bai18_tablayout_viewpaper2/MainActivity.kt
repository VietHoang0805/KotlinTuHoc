package com.example.bai18_tablayout_viewpaper2

import android.annotation.SuppressLint
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
import com.example.bai18_tablayout_viewpaper2.databinding.ActitvityMainBinding
import com.example.bai18_tablayout_viewpaper2.ui.theme.Bai18tablayoutviewpaper2Theme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActitvityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActitvityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

