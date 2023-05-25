package com.example.geeksforgeeksandroidchallenge

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.geeksforgeeksandroidchallenge.Adapter.ItemAdapter
import com.example.geeksforgeeksandroidchallenge.Data.Article
import com.example.geeksforgeeksandroidchallenge.ViewModel.NewsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var viewModel: NewsViewModel
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout = findViewById(R.id.container)

        toolbar = findViewById(R.id.mytoolbar)
        toolbar.title = "GeeksforGeeks"
        setSupportActionBar(toolbar)

        var articleList: List<Article>? = emptyList()
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.newsList.observe(this) {
            if (it != null) {
                articleList = it
                adapter = ItemAdapter(this, articleList!!)
                val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
                recyclerView.adapter = adapter

                Log.i("response", it.toTypedArray().contentToString())
            }
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.fetchNews()
            viewModel.newsList.observe(this) {
                if (it != null) {
                    articleList = it
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}