package com.example.catotech.prestntation


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.catotech.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var promoteAdapter: RecyclePromoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleView_promote = findViewById<RecyclerView>(R.id.promoteCat)
        promoteAdapter = RecyclePromoteAdapter()
        recycleView_promote.adapter = promoteAdapter

        val mainCatAdapter = MainCatAdapter()
        val recycle_main_cat = findViewById<ViewPager2>(R.id.mainCat)
        recycle_main_cat.adapter = mainCatAdapter


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.catList.observe(this){
            promoteAdapter.lst = it
            mainCatAdapter.lst = it
        }
        mainCatAdapter.onCatlickListener = {
            viewModel.changeLikeState(it)
        }

        }



    }

