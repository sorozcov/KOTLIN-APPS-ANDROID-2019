package com.example.mypersonalapplab4.ViewsFragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.mypersonalapplab4.Application.MyApplication
import com.example.mypersonalapplab4.R

import  kotlinx.android.synthetic.main.git_proyecto.*

/*Fragment para el webview con el git del proyecto.*/
class GitProyecto : Fragment() {
    private lateinit var myWebView: WebView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        var v=inflater.inflate(R.layout.git_proyecto, container, false)
        myWebView=v.findViewById<WebView>(R.id.webView)
        return v;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Git Proyecto"
        /*Luego de crear la vista, le hace load al url y le pone un titulo de lab escogido.*/
        myWebView.webViewClient = WebViewClient()
        nombreGit.text= MyApplication.nameGit.toString()
        myWebView.loadUrl(MyApplication.urlGit.toString())


    }
}