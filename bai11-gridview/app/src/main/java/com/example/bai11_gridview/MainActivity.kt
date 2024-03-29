package com.example.bai11_gridview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
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
import com.example.bai11_gridview.databinding.ActivityMainBinding
import com.example.bai11_gridview.ui.theme.Bai11gridviewTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khai báo danh sách các bộ phim
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.banghoa, "Băng Hỏa Ma Trù"))
        list.add(OutData(R.drawable.hoanhon, "Hoàn Hồn 2022"))
        list.add(OutData(R.drawable.rong, "Gia Tộc Rồng"))
        list.add(OutData(R.drawable.thanlan, "Thần Lan Chi Mộng"))

        val customGV = CustomGridView(this, list)
        binding.gvPhim.adapter = customGV

        // Lắng nghe xem có Item nào được chọn trên GridView hay không ?
        binding.gvPhim.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,
                "Bạn chọn " +list[i].tenphim,
                Toast.LENGTH_SHORT).show()
        }
    }
}

