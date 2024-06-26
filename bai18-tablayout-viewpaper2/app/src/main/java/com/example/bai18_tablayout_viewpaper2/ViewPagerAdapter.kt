package com.example.bai18_tablayout_viewpaper2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStateManagerControl
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter (fragmentManager,lifecycle) {
    // Ctrl i
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->{fragment1()}
            1->{fragment2()}
            2->{fragment3()}
            3->{fragment4()}
            else->{fragment5()}
        }
    }
}