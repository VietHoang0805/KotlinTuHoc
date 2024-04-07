package com.example.bai20_optionmenu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai20_optionmenu.databinding.ActivityMainBinding
import com.example.bai20_optionmenu.ui.theme.Bai20optionmenuTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Toolbar

    }
    // Khởi tạo menu
    override fun onCreateOptionsMenu (menu: Menu?) : Boolean {
        menuInflater.inflate(R.menu.menu2, menu)

        return super.onCreateOptionsMenu(menu)
    }
    // Xử lý sự kiện với item được chọn
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mnuExit -> finish()
            R.id.mnuHome -> Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
            R.id.mnuSearch -> Toast.makeText(this,"Search", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
