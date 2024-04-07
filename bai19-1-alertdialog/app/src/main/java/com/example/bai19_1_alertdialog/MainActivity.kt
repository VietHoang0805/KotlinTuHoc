package com.example.bai19_1_alertdialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
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
import com.example.bai19_1_alertdialog.databinding.ActivityMainBinding
import com.example.bai19_1_alertdialog.ui.theme.Bai191alertdialogTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                // Set tiêu đề của thông báo
                setTitle("Confirm Window")
                // Set nội dung thông báo
                setMessage("Do you want to close this app?")
                // nút phủ định
                setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                // nút khẳng định
                setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                    finish()
                }
                // Ngăn không cho bấm ngoài
                setCancelable(false)
            }
            dialog.show()
        }
    }
}


