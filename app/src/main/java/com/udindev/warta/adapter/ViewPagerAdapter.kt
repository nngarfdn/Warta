package com.udindev.warta.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.udindev.warta.fragment.*

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = TopFragment()
            2 -> fragment = SportFragment()
            3 -> fragment = BisnisFragment()

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title : String ? = null

        when(position){
            0 -> title = "HOME"
            1 -> title = "TOP"
            2 -> title = "SPORT"
            3 -> title = "BISNIS"

        }
        return  title
    }

}