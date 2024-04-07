package com.example.bai18_tablayout_viewpaper2

import android.annotation.SuppressLint
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
import androidx.fragment.app.FragmentActivity
import com.example.bai18_tablayout_viewpaper2.databinding.ActitvityMainBinding
import com.example.bai18_tablayout_viewpaper2.ui.theme.Bai18tablayoutviewpaper2Theme
import com.google.android.material.tabs.TabLayoutMediator

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActitvityMainBinding
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Khởi tạo viewbinding
        binding = ActitvityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adaptervv = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.pagerTest.adapter = adaptervv
        TabLayoutMediator(binding.tabDemo, binding.pagerTest) {tab,pos->
            when(pos) {
                0->{tab.text="Tab 1"}
                1->{tab.text="Tab 2"}
                2->{tab.text="Tab 3"}
                3->{tab.text="Tab 4"}
                4->{tab.text="Tab 5"}
            }
        }.attach()
    }
}

