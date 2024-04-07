package com.example.bai16_3_recyclerview

import RvAdapter
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bai16_3_recyclerview.databinding.ActivityMainBinding
import com.example.bai16_3_recyclerview.ui.theme.Bai163recyclerviewTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Xuly()
    }

    private fun Xuly() {
        var ds = mutableListOf<Int>()
        ds.add(R.drawable.tuhoc1)
        ds.add(R.drawable.tuhoc2)
        ds.add(R.drawable.tuhoc3)
        ds.add(R.drawable.tuhoc4)
        ds.add(R.drawable.tuhoc5)
        ds.add(R.drawable.tuhoc6)
        ds.add(R.drawable.tuhoc7)

        binding.rvView.layoutManager = StaggeredGridLayoutManager (
            2,StaggeredGridLayoutManager.VERTICAL
        )
        val itemAdapter = RvAdapter(ds)
        binding.rvView.adapter = itemAdapter

    }
}

