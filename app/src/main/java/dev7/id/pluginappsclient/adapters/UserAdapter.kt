package dev7.id.pluginappsclient.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.utilities.PluginUtils
import kotlinx.android.synthetic.main.adapter_user_beranda.view.*

class UserAdapter(var users : List<User>, var context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_user_beranda, parent, false))

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(users[position], context)

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User, context: Context){
            itemView.userName.text = user.name
            itemView.userId.text = user.member_id
            itemView.userImage.load("${PluginUtils.API_ENDPOINT}/images/${user.avatar}"){ transformations(CircleCropTransformation()) }
            itemView.setOnClickListener {
                Toast.makeText(context, "${user.member_id}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}