package com.example.bai14_intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai14_intent.databinding.ActivityManhinh2Binding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityManhinh2Binding
class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo Binding
        binding = ActivityManhinh2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get dữ liệu bằng bundle
        val i = intent
        // Lấy bundle ra khỏi intent
        val bundle = i.extras
        if (bundle != null)
        {
            val bienString = bundle.getString("bienString")
            val bienDouble = bundle.getDouble("bienDouble")
            val bienBoolean = bundle.getBoolean("bienBool", false)
            val bienInt = bundle.getInt("bienInt")


            binding.edtGetIntent.setText(
                    bienString + "\n" +
                    bienDouble + "\n" +
                    bienBoolean + "\n" +
                    bienInt)
        }

        // Get dữ liệu từ intent main
        /*val i = intent

        val bienString = i.getStringExtra("bienString")
        val bienDouble = i.getDoubleExtra("bienDouble",0.0)
        val bienBool = i.getBooleanExtra("bienBool", false)

        binding.edtGetIntent.setText(bienString+"\n" + bienDouble + "\n" + bienBool) */

        // Về lại màn hình chính
        binding.button.setOnClickListener {
            val i3 = Intent(this, MainActivity::class.java)
            startActivity(i3)
        }
    }
}