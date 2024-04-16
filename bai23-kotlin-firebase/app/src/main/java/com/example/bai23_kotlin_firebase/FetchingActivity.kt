package com.example.bai23_kotlin_firebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai23_kotlin_firebase.databinding.ActivityFetchingBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityFetchingBinding
class FetchingActivity : AppCompatActivity() {
    private lateinit var ds:ArrayList<EmployeeModel>
    private lateinit var dbRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFetchingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvEmp.layoutManager = LinearLayoutManager(this)
        binding.rvEmp.setHasFixedSize(true)
        ds = arrayListOf<EmployeeModel>()
        GetThongTinNV()

    }

    private fun GetThongTinNV() {
        binding.rvEmp.visibility = View.GONE
        binding.txtLoadingData.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        // Để đọc dữ liệu tại một đường dẫn và lắng nghe các thay đổi
        // Hãy sử dụng addValueEventListener
        dbRef.addValueEventListener(object : ValueEventListener{
            // ctrl + i
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()) {
                    for (empSnap in snapshot.children) {
                        val empData = empSnap.getValue(EmployeeModel::class.java)
                        ds.add(empData!!)
                    }
                    val mAdapter = EmpAdapter(ds)
                    binding.rvEmp.adapter = mAdapter

                    // Code lắng nghe sự kiện click lên trên item rv
                    mAdapter.setOnItemClickListener(object : EmpAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchingActivity,EmployeeDetailsActivity::class.java)
                            // put extras
                            intent.putExtra("empId",ds[position].empId)
                            intent.putExtra("empName",ds[position].empName)
                            intent.putExtra("empAge",ds[position].empAge)
                            intent.putExtra("empSalary",ds[position].empSalary)
                            startActivity(intent)

                        }
                    })
                    binding.rvEmp.visibility = View.VISIBLE
                    binding.txtLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}