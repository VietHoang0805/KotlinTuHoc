package com.example.bai22_3_copycsdl

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
import com.example.bai22_3_copycsdl.databinding.ActivityMainBinding
import com.example.bai22_3_copycsdl.ui.theme.Bai223copycsdlTheme

@SuppressLint("StaticFieldLeak")
private  lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    private var db:CopyDbHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // sao chép db
        db = CopyDbHelper(this)
        db?.openDatabase()
    }
}

