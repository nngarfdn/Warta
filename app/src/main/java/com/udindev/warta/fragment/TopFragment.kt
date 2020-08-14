package com.udindev.warta.fragment

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
import com.iniudin.githubuserapp.adapter.ListNewsAdapter
import com.udindev.warta.R
import com.udindev.warta.model.News
import com.udindev.warta.viewmodel.TopViewModel
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : Fragment() {

    private lateinit var topViewModel: TopViewModel
    private lateinit var adapter: ListNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        topViewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)

        if (isConnect()) {
            topViewModel.getLoading().observe(this, Observer<Boolean> { isLoading ->
                progressBar.visibility = (if (isLoading) View.VISIBLE else View.GONE)
                Log.d("Top Fragment", "onCreateView: $isLoading loading...")
            })
            topViewModel.getResults().observe(this, Observer<News> { result ->
                Log.d("TopFragment", result.toString())
                adapter = ListNewsAdapter(result.articles)
                rv_topnews.adapter = adapter
                initRecView()
            })

        } else {
            Toast.makeText(context, "Tidak ada internet", Toast.LENGTH_SHORT).show()
            progressBar.visibility = View.GONE
        }

        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onResume() {
        super.onResume()
        topViewModel.loadResults()
    }

    private fun initRecView() {
        rv_topnews.layoutManager = LinearLayoutManager(context)
        rv_topnews.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    companion object {
        fun newIntance(): TopFragment {
            return TopFragment()
        }
    }
}