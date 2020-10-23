package com.example.myliste

import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var items = Array<AndVersion>(6, { AndVersion("nom", "description",1) })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seedItems()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AndVersionAdapter(items)
    }

    fun seedItems() {
        var nameArray = resources.getStringArray(R.array.andVersionName)
        val imgArray = intArrayOf(R.drawable.cupcake, R.drawable.donut, R.drawable.birthdaycake, R.drawable.night, R.drawable.sun, R.drawable.watch)
        val desc = resources.getStringArray(R.array.descr)
        for (i in 0..(nameArray.size - 1))
            items[i] = AndVersion(nameArray[i],desc[i], imgArray[i])
    }

    private fun updateObjectList(adapter: AndVersionAdapter) {
        adapter.notifyDataSetChanged()
    }
}