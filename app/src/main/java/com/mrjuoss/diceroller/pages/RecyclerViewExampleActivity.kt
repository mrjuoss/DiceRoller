package com.mrjuoss.diceroller.pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrjuoss.diceroller.R
import com.mrjuoss.diceroller.adapters.BlogRecyclerAdapter
import com.mrjuoss.diceroller.utils.DataSource
import com.mrjuoss.diceroller.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_recycler_view_example.*

class RecyclerViewExampleActivity : AppCompatActivity() {

    private lateinit var blogAdapter : BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewExampleActivity)

            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)

            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}
