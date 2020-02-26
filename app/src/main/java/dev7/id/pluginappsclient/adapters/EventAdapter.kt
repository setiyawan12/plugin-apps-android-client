package dev7.id.pluginappsclient.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.models.Event
import kotlinx.android.synthetic.main.item_list_carousel.view.*

class EventAdapter (private var events : MutableList<Event>, private var context: Context) : RecyclerView.Adapter<EventAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(context: Context, event: Event){
            itemView.event_title.text = event.name
            itemView.imageView.load("https://static.duniaku.net/2019/03/Avengers-Endgame-poster-featured.jpg")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_carousel, parent, false))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(context, events[position])
}