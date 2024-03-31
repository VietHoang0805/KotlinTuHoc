package com.example.bai14_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai14_intent.databinding.ActivityMainBinding
import com.example.bai14_intent.ui.theme.Bai14intentTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Gọi màn hình 2
        binding.btnGo.setOnClickListener {
            val i = Intent(this,manhinh2::class.java)

            // Truyền dữ liệu bằng bundle
            // 1. nạp dữ liệu
            val bundle = Bundle()
            bundle.putString("bienString","Chào mừng đến với tuhoc.cc")
            bundle.putDouble("bienDouble", 123456.789)
            bundle.putBoolean("bienBool", true)
            bundle.putInt("bienInt",78)
            // Đặt bundle trong intent
            i.putExtras(bundle)

            // Truyền dữ liệu trực tiếp bằng intent
            /* i.putExtra("bienString","Chào mừng đến với tuhoc.cc")
            i.putExtra("bienDouble", 123456.789)
            i.putExtra("bienBool", true) */

            startActivity(i)


        }
        // Gọi url tới màn hình
        binding.btnGo2.setOnClickListener {
            val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://tuhoc.cc"))
            startActivity(i2)
        }
    }
}

