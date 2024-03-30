package com.example.bai12_datetimepicker

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
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
import com.example.bai12_datetimepicker.databinding.ActivityMainBinding
import com.example.bai12_datetimepicker.ui.theme.Bai12datetimepickerTheme
import java.util.Calendar

@SuppressLint("StaticFieldLeak")
private lateinit var binding : ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val today = Calendar.getInstance()
        //1. set thời gian khi click vào button time
        //2. Lắng nghe click lên button time
        val starHour = today.get(Calendar.HOUR_OF_DAY)
        val starMinute = today.get(Calendar.MINUTE)
        binding.btnTime.setOnClickListener {
            // Timepicker
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i , i2 ->
                //i: Giờ khi người dùng chọn
                //i2: Phút
                binding.txtTime.setText("$i:$i2")
            },starHour , starMinute,false).show()
        }

        //datepicker
        //lắng nghe click lên button date
        binding.btnDate.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                //i:năm
                //i2:tháng
                //i3:ngày
                binding.txtDate.setText("$i3/${i2+1}/$i")
            }, 2022,7,8).show()
        }
    }
}

