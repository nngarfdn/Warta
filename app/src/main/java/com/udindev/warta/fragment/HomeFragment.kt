package com.udindev.warta.fragment

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.iniudin.githubuserapp.adapter.BussinesNewsAdapter
import com.iniudin.githubuserapp.adapter.ListNewsAdapter
import com.iniudin.githubuserapp.adapter.SportNewsAdapter
import com.iniudin.githubuserapp.adapter.TopNewsAdapter
import com.udindev.warta.R
import com.udindev.warta.model.News
import com.udindev.warta.viewmodel.BussinesViewModel
import com.udindev.warta.viewmodel.SportViewModel
import com.udindev.warta.viewmodel.TopViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var bussinesViewModel: BussinesViewModel
    private lateinit var adapterBussines: BussinesNewsAdapter
    private lateinit var topViewModel: TopViewModel
    private lateinit var adapterTop : TopNewsAdapter
    private lateinit var sportViewModel: SportViewModel
    private lateinit var adapterSport: SportNewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        topViewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
        sportViewModel = ViewModelProviders.of(this).get(SportViewModel::class.java)
        bussinesViewModel = ViewModelProviders.of(this).get(BussinesViewModel::class.java)

         if (isConnect()) {
            topViewModel.getLoading().observe(this, Observer<Boolean> { isLoading ->
                progressBar.visibility = (if (isLoading) View.VISIBLE else View.GONE)
                Log.d("Top Fragment", "onCreateView: $isLoading loading...")
            })

            topViewModel.getResults().observe(this, Observer<News> { result ->
                Log.d("Home load Top", result.toString())
                adapterTop = TopNewsAdapter(result.articles)
                rv_topnews_menu.adapter = adapterTop
                initTopRecView()
            })

             bussinesViewModel.getResults().observe(this, Observer<News> { result ->
                Log.d("Home load load busines", result.toString())
                adapterBussines = BussinesNewsAdapter(result.articles)
                rv_bussinesnews_menu.adapter = adapterBussines
                initBussinesRecView()
            })


        } else {
            Toast.makeText(context, "Tidak ada internet", Toast.LENGTH_SHORT).show()
            progressBar.visibility = View.GONE
        }

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()
        topViewModel.loadResults()
        bussinesViewModel.loadResults()
        sportViewModel.loadResults()

    }

    private fun initTopRecView() {
        rv_topnews_menu.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_topnews_menu.setHasFixedSize(true)
        adapterTop.notifyDataSetChanged()
    }

    private fun initBussinesRecView() {
        rv_bussinesnews_menu.layoutManager = LinearLayoutManager(context)
        rv_bussinesnews_menu.setHasFixedSize(true)
        adapterBussines.notifyDataSetChanged()
    }

    private fun initSportRecView() {
        rv_topnews_menu.layoutManager = LinearLayoutManager(context)
        rv_topnews_menu.setHasFixedSize(true)
        adapterSport.notifyDataSetChanged()
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

     companion object {
        fun newIntance(): HomeFragment {
            return HomeFragment()
        }
    }

}