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
            0 -> fragment = TopFragment()
            1 -> fragment = SportFragment()
            2 -> fragment = BisnisFragment()
            3 -> fragment = SainFragment()
            4 -> fragment = TeknoFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title : String ? = null

        when(position){
            0 -> title = "TOP"
            1 -> title = "SPORT"
            2 -> title = "BISNIS"
            3 -> title = "SAINS"
            4 -> title = "TECH"
        }
        return  title
    }

}