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
        val title2 = "Serie"
        val videos2 = ArrayObjectAdapter(Card())
        videos2.addAll(0, listOf(
            /*Video("cancion", "documental", R.atardecer, "La vida en el hielo Antártico.", R.raw.mira),
            Video("cancion", "documental", R.cuco, "La vida en el hielo Antártico.", R.raw.california),*/
            Video("cancion", "serie de televisión animada francesa, Miraculous: Las aventuras de Ladybug, y a las joyas mágicas llamadas Miraculous que utilizan los protagonistas de la serie para transformarse en superhéroes", R.mipmap.series, "Un día de pesca del Pinguino Emperador.", R.raw.mira),
        ))
        val header2 = HeaderItem(2, title2)
        categories.add(ListRow(header2, videos2))

                // Tercera Categoría
        val title3  = "Música"
        val videos3 = ArrayObjectAdapter(Card())
        videos2.addAll(0, listOf(
            /*Video("cancion", "documental", R.atardecer, "La vida en el hielo Antártico.", R.raw.mira),
            Video("cancion", "documental", R.cuco, "La vida en el hielo Antártico.", R.raw.california),*/
            Video("cancion", "yghy7", R.mipmap.mus, "Un día de pesca del Pinguino Emperador.", R.raw.mira),
        ))
        val header3 = HeaderItem(2, title3)
        categories.add(ListRow(header3, videos3))
        /*
                        // --- 4. Cuarta Categoría: Camaleón ---
                        val title4 = "Camaleón"
                        val videos4 = ArrayObjectAdapter(Card())
                        videos4.addAll(0, listOf(
                            Video("colores", "naturaleza", R.mipmap.imagen_e, "El arte del mimetismo.", R.raw.video_e),
                            Video("selva", "bosque", R.mipmap.imagen_f, "Cazando bichos con la lengua.", R.raw.video_f)
                        ))
                        val header4 = HeaderItem(4, title4)
                        categories.add(ListRow(header4, videos4))

                        // --- 5. Quinta Categoría: Delfín ---
                        val title5 = "Delfín"
                        val videos5 = ArrayObjectAdapter(Card())
                        videos5.addAll(0, listOf(
                            Video("saltos", "acrobacia", R.mipmap.imagen_g, "Delfines jugando en la bahía.", R.raw.video_g),
                            Video("inteligencia", "ciencia", R.mipmap.imagen_h, "Comunicación y sonar del Delfín.", R.raw.video_h)
                        ))
                        val header5 = HeaderItem(5, title5)
                        categories.add(ListRow(header5, videos5))*/

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