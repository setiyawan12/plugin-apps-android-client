package dev7.id.pluginappsclient.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.api.load
import com.smarteist.autoimageslider.SliderViewAdapter
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.models.Event
import kotlinx.android.synthetic.main.adapter_carousel.view.*


class CarouselAdapter(var context : Context, var events : List<Event>) : SliderViewAdapter<CarouselAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_carousel, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.bind(events[position], context)

    override fun getCount() = events.size

    class ViewHolder(var itemView : View) : SliderViewAdapter.ViewHolder(itemView){
        fun bind(event: Event, context: Context){
            itemView.image.load(event.image)
            itemView.setOnClickListener{
                Toast.makeText(context, event.name, Toast.LENGTH_LONG).show()
            }
        }
    }
}