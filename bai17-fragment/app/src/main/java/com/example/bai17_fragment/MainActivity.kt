package com.example.bai17_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.example.bai17_fragment.databinding.ActivityMainBinding
import com.example.bai17_fragment.ui.theme.Bai17fragmentTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sub1 = Fragment1()
        val sub2 = Fragment2()

        binding.btnf1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub1)
                commit()
            }
        }
        binding.btnf2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl1,sub2)
                commit()
            }
        }
    }
}
