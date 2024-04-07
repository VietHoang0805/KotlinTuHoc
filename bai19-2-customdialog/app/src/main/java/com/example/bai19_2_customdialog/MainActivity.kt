package com.example.bai19_2_customdialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
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
import com.example.bai19_2_customdialog.databinding.ActivityMainBinding
import com.example.bai19_2_customdialog.databinding.CustomDialogBinding
import com.example.bai19_2_customdialog.ui.theme.Bai192customdialogTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            showDialogBinding()
        }
    }

    private fun showDialogBinding() {
        val build = AlertDialog.Builder(this, R.style.Themecustom)
        val dialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
        build.setView(dialogBinding.root)
        // Code close
        dialogBinding.btnClose.setOnClickListener() {
            dialog.dismiss()
        }
        // Code cho nút tham gia
        dialogBinding.btnThamgia.setOnClickListener() {
            Toast.makeText(
                this,
                "Bạn đã tham gia thành công",
                Toast.LENGTH_SHORT).show()
        }
        dialog = build.create()
        dialog.show()

    }
}

