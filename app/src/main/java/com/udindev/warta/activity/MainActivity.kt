package com.udindev.warta.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.udindev.warta.R
import com.udindev.warta.adapter.ViewPagerAdapter
import com.udindev.warta.fragment.BisnisFragment
import com.udindev.warta.fragment.HomeFragment
import com.udindev.warta.fragment.SportFragment
import com.udindev.warta.fragment.TopFragment
import com.udindev.warta.model.News
import com.udindev.warta.viewmodel.TopViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigationView()
    }


    private fun initBottomNavigationView() {
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.top))
        bottomNavigation.add(
            MeowBottomNavigation.Model(4, R.drawable.sport))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.bussines)
        )

        bottomNavigation.setOnShowListener {
            when (it.id) {
                1 -> setFragment(HomeFragment.newIntance())
                2 -> setFragment(TopFragment.newIntance())
                3 -> setFragment(BisnisFragment.newIntance())
                4 -> setFragment(SportFragment.newIntance())
            }
        }

        bottomNavigation.show(1)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment, "MainActivity")
            .commit()
    }

}