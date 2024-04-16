package com.example.bai23_kotlin_firebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bai23_kotlin_firebase.databinding.ActivityEmployeeDetailsBinding
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityEmployeeDetailsBinding
class EmployeeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityEmployeeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setValueToView()
        // Code cho button delete
        binding.btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("empId").toString()
            )
        }
    }

    private fun deleteRecord(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
        val mTask = dbRef.removeValue()
        mTask.addOnSuccessListener {
            Toast.makeText(this,"Employee data đã xóa",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,FetchingActivity::class.java)
            finish()
            startActivity(intent)

        }.addOnFailureListener {err ->
            Toast.makeText(this,"Delete err ${err.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setValueToView() {
        binding.tvEmpId.text = intent.getStringExtra("empId")
        binding.tvEmpName.text = intent.getStringExtra("empName")
        binding.tvEmpAge.text = intent.getStringExtra("empAge")
        binding.tvEmpSalary.text = intent.getStringExtra("empSalary")
    }
}