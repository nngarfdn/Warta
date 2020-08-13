package com.udindev.warta.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.udindev.warta.R
import com.udindev.warta.adapter.ViewPagerAdapter
import com.udindev.warta.model.News
import com.udindev.warta.viewmodel.TopViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabLayout()

        val topViewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)

        topViewModel.getResults().observe(this, Observer<News>{ result ->
            Log.d("MainActivity", result.toString())
        })
    }


    private fun setupTabLayout() {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(viewPager)
    }
}