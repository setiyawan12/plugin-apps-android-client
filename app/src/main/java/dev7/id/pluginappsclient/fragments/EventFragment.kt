package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.CarouselAdapter
import dev7.id.pluginappsclient.models.Event
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class EventFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.fragment_event, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val events = mutableListOf<Event>().apply {
            add(Event(1, "Pacar Ke 1 saya", "https://d3t543lkaz1xy.cloudfront.net/photo/5c934bf5da3b333254a9dfde_m"))
            add(Event(1, "Pacar Ke 2 saya", "https://cdns.klimg.com/resized/670x335/p/headline/lucunya-lisa-blackpink-pakai-hoodie-ber-887da6.jpg"))
            add(Event(1, "Mobile Bucin Saya", "https://cdn.bringatrailer.com/wp-content/uploads/2019/01/2014_lamborghini_gallardo_lp570-4_squadra_corse_154939335774674751f941082IMG_6502-940x554.jpg"))
            add(Event(1, "Tapi Kan Cocote Tok :V", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKeigzh0DIqwVhrHlcwBMWiKpy3Ui6lKFHqJdNT-Wx5lv4g2LU9w&s")

            )
        }
        view.imageSlider.sliderAdapter = CarouselAdapter(activity!!, events)
        view.imageSlider.startAutoCycle()
        view.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        view.imageSlider.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
    }
    }
