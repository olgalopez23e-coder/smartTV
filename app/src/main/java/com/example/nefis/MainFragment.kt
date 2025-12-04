package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="Un poco de todo"

        // 1. Adaptador principal para todas las categorías (filas)
        val categories = ArrayObjectAdapter(ListRowPresenter())

        // --- Categorías  ---
        val title1 = "Cuco"
        val videos1 = ArrayObjectAdapter(Card())
        videos1.addAll(0, listOf(
            Video("Cuco_bebe", "le gusta hacer cualquier cosa", R.mipmap.cuco, "le gusta hacer cualquier cosa", R.raw.cuco1),
            Video("Cuco ", "michi", R.mipmap.cuco, "cuco enojado", R.raw.cuco2),
            Video("cuco", "michi", R.mipmap.cuco, "Esta es la descripción de Cuco", R.raw.cuco3),
            Video("cuco", "michi", R.mipmap.cuco, "Esta es la descripción de Cuco", R.raw.cuco4),
            Video("cuco", "michi", R.mipmap.cuco, "Esta es la descripción de Cuco", R.raw.cuco5)
        ))
        val header1 = HeaderItem(1, title1)
        categories.add(ListRow(header1, videos1))

// --- Segunda Categoría:
        val title2 = "Caricaturas"
        val videos2 = ArrayObjectAdapter(Card())
        videos2.addAll(0, listOf(
            Video("caricaturas", "miraculous", R.mipmap.series, "serie de televisión animada francesa, Miraculous: Las aventuras de Ladybug, y a las joyas mágicas llamadas Miraculous que utilizan los protagonistas de la serie para transformarse en superhéroes", R.raw.serie),
            Video("caricaturas", "Chilly willy", R.mipmap.series, "serie de televisión animada, un pingüino caricaturesco que busca calor y comida, a menudo metiéndose en problemas con un perro llamado Smedley", R.raw.serie1),
            Video("caricaturas", "Los padrinos magicos", R.mipmap.series, "serie de televisión animada, Timmy Turner, un niño de 10 años a quien sus padres le dejan a cargo de la malvada niñera Vicky. Para ayudarlo, le asignan dos padrinos mágicos: Cosmo y Wanda, quienes le conceden deseos.", R.raw.serie2),
            Video("caricaturas", "El chavo del 8", R.mipmap.series, "serie de televisión animada, trata de un grupo de personajes que habitan una vecindad, con el protagonista, el Chavo, un niño huérfano que vive en un barril y se mete en líos con los demás por malentendidos o travesuras", R.raw.serie3),
            Video("caricaturas", "El parajaro loco", R.mipmap.series, "serie de televisión animada, El Pájaro Loco trata principalmente de la película de 2017 donde un abogado, Lance Walters, planea construir una casa en el bosque y entra en conflicto con el Pájaro Loco, un pájaro carpintero que defiende su hogar.", R.raw.serie4),




        ))
        val header2 = HeaderItem(2, title2)
        categories.add(ListRow(header2, videos2))

                // Tercera Categoría
        val title3  = "Musica"
        val videos3 = ArrayObjectAdapter(Card())
        videos3.addAll(0, listOf(
            Video("Canción", "mis gustos", R.mipmap.musica,"Fragmento de cancion que me gusto por alguna razon",R.raw.musica1),
            Video("Canción", "mis gustos", R.mipmap.musica,"Fragmento de cancion que me gusto por alguna razon",R.raw.musica2),
            Video("Canción", "mis gustos", R.mipmap.musica,"Fragmento de cancion que me gusto por alguna razon",R.raw.musica3),
            Video("Canción", "mis gustos", R.mipmap.musica,"Fragmento de cancion que me gusto por alguna razon",R.raw.musica4),
            Video("Canción", "mis gustos", R.mipmap.musica,"Fragmento de cancion que me gusto por alguna razon",R.raw.musica5),



        ))
        val header3 = HeaderItem(3, title3)
        categories.add(ListRow(header3, videos3))

                        // --- Cuarta Categoría
                        val title4 = "Memes"
                        val videos4 = ArrayObjectAdapter(Card())
                        videos4.addAll(0, listOf(
                            Video("Memes de instagram", "Memes", R.mipmap.meme,"Memes sobre la uni", R.raw.meme),
                            Video("Memes de instagram", "Memes", R.mipmap.meme,"Memes sobre la uni", R.raw.meme1),
                            Video("Memes de instagram", "Memes", R.mipmap.meme,"Memes sobre la uni", R.raw.meme2),
                            Video("Memes de instagram", "Memes", R.mipmap.meme,"Memes sobre la uni", R.raw.meme3),
                            Video("Memes de instagram", "Memes", R.mipmap.meme,"Memes sobre la uni", R.raw.meme4),


                        ))
                        val header4 = HeaderItem(4, title4)
                        categories.add(ListRow(header4, videos4))

                                // Quinta Categoría
                                val title5 = "Videos entetenidos pero raros"
                                val videos5 = ArrayObjectAdapter(Card())
                                videos5.addAll(0, listOf(
                                    Video("youtube", "", R.mipmap.videos, "introduccion de 25 cosas que no sabias", R.raw.videos),
                                    Video("youtube", "viaje", R.mipmap.videos, "video de exploracion en alguna tierra de españa", R.raw.videos1),
                                    Video("youtube", "viaje", R.mipmap.videos, "24 horas en una casa del arbol", R.raw.videos2),
                                    Video("youtube", "chef", R.mipmap.videos, "siendo chef por 24hr.", R.raw.videos3),
                                    Video("youtube", "raro", R.mipmap.videos, "100 españoles dijeron", R.raw.videos4),

                                   ))
                                val header5 = HeaderItem(5, title5)
                                categories.add(ListRow(header5, videos5))

        // 2. Asignar el adaptador al fragmento
        adapter = categories

        // 3. Listener para manejar el click en los videos (sin cambios)
        onItemViewClickedListener= OnItemViewClickedListener{ _, video, _, _ ->
            val intent=Intent(requireContext(), PlayActivity::class.java).apply{
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}