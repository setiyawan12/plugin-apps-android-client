package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import coil.api.load
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.EventAdapter
import dev7.id.pluginappsclient.models.Event
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_event.view.*
import kotlinx.android.synthetic.main.item_list_carousel.view.*

class EventFragment : Fragment(R.layout.fragment_event){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carouselView.apply {
            resource = R.layout.item_list_carousel
            autoPlay = true
            indicatorAnimationType = IndicatorAnimationType.THIN_WORM
            carouselOffset = OffsetType.START
            setCarouselViewListener { view, position ->
                view.imageView.load("https://d15hng3vemx011.cloudfront.net/attachment/66838678621842369664.large")
            }
            show()
        }

        val eventsDummy = mutableListOf<Event>()
        var i = 0
        while(i < 10){
            eventsDummy.add(Event(i, "Event $i", ""))
            i++
        }
        view.rv_all_event.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = EventAdapter(eventsDummy, activity!!)
        }
    }
}
