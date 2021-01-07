package com.hackaprende.tinynetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackaprende.tinynetflix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sectionRecycler.layoutManager = LinearLayoutManager(this)
        val sectionAdapter = SectionAdapter(this) {
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
        binding.sectionRecycler.adapter = sectionAdapter

        sectionAdapter.submitList(downloadFakeMovies())
    }

    private fun downloadFakeMovies(): List<Section> {
        val fantasy1 = Movie("El señor de los anillos", "https://thehande.files.wordpress.com/2015/01/fellowship.jpg")
        val fantasy2 = Movie("Harry Potter", "https://2.bp.blogspot.com/-nZjlBr_J1Ck/VbEA-9d5WoI/AAAAAAAAFl8/7w-tZ0K55t4/s1600/harry-potter-y-la-piedra-filosofal-poster.jpg")
        val fantasyMovies = listOf(fantasy1, fantasy2)

        val fantasySection = Section("Fantasía", fantasyMovies)

        val scienceFiction1 = Movie("Volver al futuro", "https://movierob.files.wordpress.com/2018/01/bttf.jpg")
        val scienceFiction2 = Movie("Matrix", "https://es.web.img2.acsta.net/pictures/19/08/07/09/08/5783887.jpg")
        val scienceFiction3 = Movie("Ready player one", "https://fanart.tv/fanart/movies/333339/movieposter/ready-player-one-5abf422a72873.jpg")
        val scienceFiction4 = Movie("Interestelar", "https://filmgrimoire.files.wordpress.com/2015/04/imax-poster-for-interstellar.jpg")
        val sfMovies = listOf(scienceFiction1, scienceFiction2, scienceFiction3, scienceFiction4)

        val sfSection = Section("Ciencia ficción", sfMovies)

        val christmas1 = Movie("Cronicas de navidad 1", "https://1.bp.blogspot.com/-t9d6lKNnmmo/XTG_n36fcgI/AAAAAAAA3oc/sRyIwsEZntsnC243yLJhCIPDJHBshgavQCPcBGAYYCw/s1600/CronicasDeNavidad.jpg")
        val christmas2 = Movie("Cronicas de navidad 2", "https://mx.web.img2.acsta.net/pictures/20/10/20/08/59/0323500.jpg")
        val christmas3 = Movie("Klaus", "https://es.web.img2.acsta.net/pictures/19/10/07/12/38/2313944.jpg")
        val christmasMovies = listOf(christmas1, christmas2, christmas3)
        val christmasSection = Section("Navidad", christmasMovies)

        val comedy1 = Movie("Guerra de papás", "https://hackstore.net/wp-content/uploads/2016/03/Guerra-de-Papas-DVDRip-Audio-Latino-Cover-2016-Poster.jpg")
        val comedy2 = Movie("Donde están las rubias", "https://resizing.flixster.com/vtt4fmSFGGp9y6um_T9IzOgvdFQ=/800x1200/dkpu1ddg7pbsk.cloudfront.net/movie/11/16/98/11169876_ori.jpg")
        val comedy3 = Movie("Scary Movie", "https://img.hindilinks4u.to/2014/11/Scary-Movie-2000-In-Hindi.jpg")
        val comedy4 = Movie("Cualquiera de Adam Sandler", "https://4.bp.blogspot.com/__vyu75DGJsY/SZXZHNb4msI/AAAAAAAAAGo/sDcd5v0gdng/s320/2424-como_si_fuera_la_primera_vez-.jpg")
        val comedyMovies = listOf(comedy1, comedy2, comedy3, comedy4)
        val comedySection = Section("Comedia", comedyMovies)

        return listOf(fantasySection, sfSection, christmasSection, comedySection)
    }
}