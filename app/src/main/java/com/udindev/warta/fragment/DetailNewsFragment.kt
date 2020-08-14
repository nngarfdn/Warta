package com.udindev.warta.fragment

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.udindev.warta.R
import com.udindev.warta.model.ArticlesItem
import kotlinx.android.synthetic.main.fragment_detail_news.*
import kotlinx.android.synthetic.main.fragment_detail_news.view.*


class DetailNewsFragment : Fragment() {

    companion object {
        val EXTRA_URL = "extra_url"
    }

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
        val view = inflater.inflate(R.layout.fragment_detail_news, container, false)

        val url : String? = arguments?.getString(EXTRA_URL)

        view.webViewFragment.loadUrl(url!!)

        view.webViewFragment.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                view?.loadingArticle?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                view?.loadingArticle?.visibility = View.INVISIBLE
            }
        }
        return view
    }




}