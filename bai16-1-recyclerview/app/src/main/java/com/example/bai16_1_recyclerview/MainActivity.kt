package com.example.bai16_1_recyclerview

import RvAdapter
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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai16_1_recyclerview.databinding.ActivityMainBinding
import com.example.bai16_1_recyclerview.ui.theme.Bai161recyclerviewTheme
import java.util.Objects

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tạo ds
        val ds = mutableListOf<OutData>()
        ds.add(OutData(R.drawable.banghoa, "Băng hỏa Ma Trù", "Phim Trung Quốc"))
        ds.add(OutData(R.drawable.hoanhon, "Hoàn Hồn", "Phim Trung Quốc"))
        ds.add(OutData(R.drawable.rong, "Gia Tộc Rồng", "Phim Mỹ"))
        ds.add(OutData(R.drawable.thanlan, "Thần Lan Chi Mộng", "Phim Trung Quốc"))
        ds.add(OutData(R.drawable.banghoa, "Băng hỏa Ma Trù", "Phim Trung Quốc"))
        ds.add(OutData(R.drawable.hoanhon, "Hoàn Hồn", "Phim Trung Quốc"))
        ds.add(OutData(R.drawable.rong, "Gia Tộc Rồng", "Phim Mỹ"))
        ds.add(OutData(R.drawable.thanlan, "Thần Lan Chi Mộng", "Phim Trung Quốc"))

        val adapter = RvAdapter(ds, object : RvInterface {
            override fun OnClickPhim(pos: Int) {
                Toast.makeText(this@MainActivity,
                    "Bạn đã click vào ${ds[pos].tenPhim}",
                    Toast.LENGTH_SHORT).show()
            }

        })
        binding.rvDemo.adapter = adapter
        binding.rvDemo.layoutManager = GridLayoutManager (
            this,
            2,
            GridLayoutManager.HORIZONTAL,false
        )
    }
}

