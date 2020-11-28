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
        val sectionAdapter = SectionAdapter(this)
        recycler.adapter = sectionAdapter

        sectionAdapter.submitList(downloadFakeMovies())
    }

    private fun downloadFakeMovies(): List<Section> {
        val fantasy1 = Movie("El señor de los anillos")
        val fantasy2 = Movie("Harry Potter")
        val fantasyMovies = listOf(fantasy1, fantasy2)

        val fantasySection = Section("Fantasía", fantasyMovies)

        val scienceFiction1 = Movie("Volver al futuro")
        val scienceFiction2 = Movie("Matrix")
        val scienceFiction3 = Movie("Ready player one")
        val scienceFiction4 = Movie("Interestelar")
        val sfMovies = listOf(scienceFiction1, scienceFiction2, scienceFiction3, scienceFiction4)

        val sfSection = Section("Ciencia ficción", sfMovies)

        val christmas1 = Movie("Cronicas de navidad 1")
        val christmas2 = Movie("Cronicas de navidad 2")
        val christmas3 = Movie("Klaus")
        val christmasMovies = listOf(christmas1, christmas2, christmas3)
        val christmasSection = Section("Navidad", christmasMovies)

        val comedy1 = Movie("Guerra de papás")
        val comedy2 = Movie("Donde están las rubias")
        val comedy3 = Movie("Scary Movie")
        val comedy4 = Movie("Cualquiera de Adam Sandler")
        val comedyMovies = listOf(comedy1, comedy2, comedy3, comedy4)
        val comedySection = Section("Comedia", comedyMovies)

        return listOf(fantasySection, sfSection, christmasSection, comedySection)
    }
}