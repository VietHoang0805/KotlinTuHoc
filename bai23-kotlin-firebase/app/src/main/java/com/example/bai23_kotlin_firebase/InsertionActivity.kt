package com.example.bai23_kotlin_firebase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bai23_kotlin_firebase.databinding.ActivityInsertionBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityInsertionBinding
class InsertionActivity : AppCompatActivity() {
    private lateinit var dbRef :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        // Xử lý sự kện khi click vào nút save
        binding.btnSave.setOnClickListener {
            saveEmployeeData()
        }
    }

    private fun saveEmployeeData() {
        // getting value từ ô nhập liệu
        val empName = binding.edtEmpName.text.toString()
        val empAge = binding.edtEmpAge.text.toString()
        val empSalary = binding.edtEmpSalary.text.toString()

        // Đẩy dữ liệu
        val empId = dbRef.push().key!!
        val employee = EmployeeModel(empId,empName,empAge,empSalary)

        // Kiểm tra điều kiện ở ô nhập liệu
        if (empName.isEmpty()) {
            binding.edtEmpName.error = "Please enter name"
            return
        }
        if (empAge.isEmpty()) {
            binding.edtEmpAge.error = "Please enter age"
            return
        }
        if (empSalary.isEmpty()) {
            binding.edtEmpSalary.error = "Please enter salary"
            return
        }
        // Tạo các attribute ở trong bảng bằng cách sử dụng child
        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this,"Data insert thành công", Toast.LENGTH_SHORT).show()
                binding.edtEmpName.setText("")
                binding.edtEmpAge.setText("")
                binding.edtEmpSalary.setText("")
            }
            .addOnFailureListener {err ->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }
}