package com.example.bai20_2_contextmenu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai20_2_contextmenu.databinding.ActivityMainBinding
import com.example.bai20_2_contextmenu.ui.theme.Bai202contextmenuTheme

@SuppressLint("StaticFieldLeak")
private lateinit var binding : ActivityMainBinding
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Đăng ký menu ngữ cảnh
        registerForContextMenu(binding.txtContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // add(int groupId, int  itemId, int Order, CharSequence Title
        menu?.add(1,1,1,"red")
        menu?.add(1,2,2,"green")
        menu?.add(1,3,3,"black")
        /* setGroupCheckable (int group,
        boolean checkable,
        boolean exclusive)
        1. group: id của group muốn có nút check
        2. boolean: true để cho phép dấu kiểm, false sẽ là không cho phép
        mặc định là false
        3. Chọn true để chỉ được chọn 1 item trong group
           Chọn false tích cho được nhiều lựa chọn
        * */
        // Khởi tạo submenu
        var subMenu = menu?.addSubMenu("Giới tính")
        subMenu?.add(2,21,1, "Female")?.setChecked(true)
        subMenu?.add(2,22,2, "Male")
        subMenu?.setGroupCheckable(2, true, true)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            1->{binding.txtOption.setTextColor(android.graphics.Color.RED)}
            2->{binding.txtOption.setTextColor(android.graphics.Color.GREEN)}
            3->{binding.txtOption.setTextColor(android.graphics.Color.BLACK)}
            // Tương tác với submenu
            21->(binding.txtOption.setText("Female"))
            22->(binding.txtOption.setText("Male"))

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Mời quý vị chọn màu")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            31->{binding.txtContext.setTextColor(android.graphics.Color.RED)}
            32->{binding.txtContext.setTextColor(android.graphics.Color.GREEN)}
            33->{binding.txtContext.setTextColor(android.graphics.Color.BLACK)}
        }
        return super.onContextItemSelected(item)
    }
}

