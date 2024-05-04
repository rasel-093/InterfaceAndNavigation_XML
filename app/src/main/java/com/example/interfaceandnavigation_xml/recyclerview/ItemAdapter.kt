package com.example.interfaceandnavigation_xml.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.R
import com.example.interfaceandnavigation_xml.model.User

class ItemAdapter(
    private val userList: ArrayList<User>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userNameTV: TextView = view.findViewById(R.id.item_title)
        val lastMsgTV: TextView = view.findViewById(R.id.last_message)
        val timeTV: TextView = view.findViewById(R.id.item_time)
        val profilePicIV: ImageView = view.findViewById(R.id.item_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = userList[position]
        holder.userNameTV.text = item.name
        holder.lastMsgTV.text = item.lastMsg
        holder.timeTV.text = item.time
        holder.profilePicIV.setImageResource(item.profileImg)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}