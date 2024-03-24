package com.example.bai10_autocompletetextview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
import com.example.bai10_autocompletetextview.databinding.ActivityMainBinding
import com.example.bai10_autocompletetextview.ui.theme.Bai10autocompletetextviewTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = resources.getStringArray(R.array.tinhthanh)

        val adt = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, list)

        binding.autoTinhThanh.setAdapter(adt)

        // Gợi ý với 0 ký tự nhập vào
        binding.autoTinhThanh.setOnFocusChangeListener({view , b -> if (b) binding.autoTinhThanh.showDropDown()})

        // Kiểm tra xem item nào được chọn
        binding.autoTinhThanh.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,
                "Bạn đã chọn "+ binding.autoTinhThanh.text.toString(),
                Toast.LENGTH_SHORT).show()
        })


    }
}
