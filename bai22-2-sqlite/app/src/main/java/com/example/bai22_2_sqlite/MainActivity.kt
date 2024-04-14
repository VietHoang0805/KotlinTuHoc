package com.example.bai22_2_sqlite

import android.content.ContentValues
import android.os.Bundle
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
import com.example.bai22_2_sqlite.databinding.ActivityMainBinding
import com.example.bai22_2_sqlite.ui.theme.Bai222sqliteTheme

private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper = MyDbHelper(applicationContext)
        val db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)
         if (rs.moveToLast())
             Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_SHORT).show()

        // Lắng nghe sự kiện click lên btnAdd
        binding.btnAdd.setOnClickListener {
            var cv = ContentValues()
            cv.put("UNAME", binding.edtUser.text.toString())
            cv.put("PWD", binding.edtPWD.text.toString())
            db.insert("USERS",null,cv)
            Toast.makeText(applicationContext,"Add thành công",Toast.LENGTH_SHORT).show()
            // reset 2 ô nhập liệu
            binding.edtUser.setText("")
            binding.edtPWD.setText("")
            binding.edtUser.requestFocus()
        }
    }
}
