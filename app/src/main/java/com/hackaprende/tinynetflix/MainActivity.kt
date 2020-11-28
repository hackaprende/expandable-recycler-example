package com.hackaprende.tinynetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.section_recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        val sectionAdapter = SectionAdapter()
        recycler.adapter = sectionAdapter

        sectionAdapter.submitList(downloadFakeMovies())
    }

    private fun downloadFakeMovies(): List<Section> {
        val section1 = Section("Fantasia")
        val section2 = Section("Comedia")
        val section3 = Section("Horror")
        val section4 = Section("Ciencia Ficción")

        return listOf(section1, section2, section3, section4)
    }
}