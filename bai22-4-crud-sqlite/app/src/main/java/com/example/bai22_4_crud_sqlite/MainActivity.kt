package com.example.bai22_4_crud_sqlite

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
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
import com.example.bai22_4_crud_sqlite.databinding.ActivityMainBinding
import com.example.bai22_4_crud_sqlite.ui.theme.Bai224crudsqliteTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor
    lateinit var adapter: SimpleCursorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = MyHelper(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("SELECT * FROM TUHOC LIMIT 20", null)
        // sql : String chuỗi câu lệnh sql
        // String[] selectionArgs : Chọn lọc dữ liệu với điều kiện mảng

        // Code cho chức button first
        binding.btnFirst.setOnClickListener {
            if (rs.moveToFirst()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else {
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
            }
        }
        // Code cho button next
        binding.btnNext.setOnClickListener {
            if (rs.moveToNext()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else if (rs.moveToFirst()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else {
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
            }
        }
        // Code cho button Prev
        binding.btnPrev.setOnClickListener {
            if (rs.moveToPrevious()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else if (rs.moveToLast()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else {
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
            }
        }
        // Code cho button last
        binding.btnLast.setOnClickListener {
            if (rs.moveToLast()) {
                binding.edtUser.setText(rs.getString(1))
                binding.edtEmail.setText(rs.getString(2))
            }
            else {
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
            }
        }
        // Code cho nút insert
        binding.btnInsert.setOnClickListener {
            var cv = ContentValues()
            cv.put("user", binding.edtUser.text.toString())
            cv.put("email", binding.edtEmail.text.toString())
            db.insert("TUHOC",null,cv)
            rs.requery()
            adapter.notifyDataSetChanged()

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Add record")
            ad.setMessage("Add thành công")
            ad.setPositiveButton("Ok",DialogInterface.OnClickListener { dialog, which ->
                binding.edtUser.setText("")
                binding.edtEmail.setText("")
                binding.edtUser.requestFocus()

            })
            ad.show()
        }
        //9. code cho nút update
        binding.btnUpdate.setOnClickListener {
            if (rs.moveToPosition(rs.position)) {  // Move to current position
                var cv = ContentValues()
                cv.put("user", binding.edtUser.text.toString())
                cv.put("email", binding.edtEmail.text.toString())

                // Update the current row based on the _id column value
                db.update("TUHOC", cv, "_id=?", arrayOf(rs.getString(rs.getColumnIndexOrThrow("_id"))))
                rs.requery()
                adapter.notifyDataSetChanged()

                var ad = AlertDialog.Builder(this)
                ad.setTitle("Update record")
                ad.setMessage("Update thành công")
                ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    binding.edtUser.setText("")
                    binding.edtEmail.setText("")
                    binding.edtUser.requestFocus()
                })
                ad.show()
            } else {
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
            }
        }


        // Code cho nút delete
        binding.btnDelete.setOnClickListener {
            db.delete("TUHOC","_id=?", arrayOf(rs.getString(0)))
            rs.requery()
            adapter.notifyDataSetChanged()
            //thông báo
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Delete record")
            ad.setMessage("Delete thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                if (rs.moveToFirst()){
                    binding.edtUser.setText("")
                    binding.edtEmail.setText("")
                    binding.edtUser.requestFocus()
                }
                else
                {
                    binding.edtUser.setText("No data found")
                    binding.edtEmail.setText("No data found")
                }

            })
            ad.show()
        }
        // Code cho button clear
        binding.btnClear.setOnClickListener {
            binding.edtUser.setText("")
            binding.edtEmail.setText("")
            binding.edtUser.requestFocus()
        }

        // Code cho phần lvFull
        adapter = SimpleCursorAdapter(
            applicationContext,android.R.layout.simple_expandable_list_item_2,rs,
            arrayOf("user","email"), intArrayOf(android.R.id.text1,android.R.id.text2),0
        )
        binding.lvFull.adapter = adapter
        // Code cho button Viewall
        binding.btnViewAll.setOnClickListener {
            binding.searchView.visibility = View.VISIBLE
            binding.lvFull.visibility = View.VISIBLE
            adapter.notifyDataSetChanged()
            binding.searchView.queryHint = "Tìm kiếm trong ${rs.count} bản ghi"

        }

        // Code cho phần tìm kiếm nội dung
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                rs = db.rawQuery("SELECT * FROM TUHOC WHERE user LIKE '%${newText}' or email LIKE '%${newText}'",null)
                adapter.changeCursor(rs)
                return true
            }
        })

        // Đăng ký sử dụng context menu cho listview lvFull
        registerForContextMenu(binding.lvFull)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(100,11,1,"Delete")
        menu?.setHeaderTitle("Removing Data")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 11) {
            //Toast.makeText(applicationContext,"Đã click lên đây",Toast.LENGTH_SHORT).show()
            db.delete("TUHOC","_id=?",arrayOf(rs.getString(0)))
            rs.requery()
            adapter.notifyDataSetChanged()
            binding.searchView.queryHint = "Tìm kiếm trong ${rs.count} bản ghi"
        }
        return super.onContextItemSelected(item)
    }
}
