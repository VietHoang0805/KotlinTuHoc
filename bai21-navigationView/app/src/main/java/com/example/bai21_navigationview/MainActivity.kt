package com.example.bai21_navigationview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai21_navigationview.databinding.ActivityMainBinding
import com.example.bai21_navigationview.ui.theme.Bai21navigationViewTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sử dụng màu cho icon menu
        binding.navLeftmenu.itemIconTintList = null

        // Lắng nghe sự kiện click lên lên các item menu
        binding.navLeftmenu.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_Home-> Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                R.id.nav_message-> Toast.makeText(this,"Message",Toast.LENGTH_SHORT).show()
                R.id.nav_exit-> finish()
            }
            true
        }

    }
}
