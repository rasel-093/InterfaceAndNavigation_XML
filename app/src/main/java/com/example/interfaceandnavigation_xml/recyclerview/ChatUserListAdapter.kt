package com.example.interfaceandnavigation_xml.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.R
import com.example.interfaceandnavigation_xml.model.User

class ChatUserListAdapter(
    private val userList: ArrayList<User>
): RecyclerView.Adapter<ChatUserListAdapter.ItemViewHolder>() {

    interface OnItemClickListener {fun onItemClick(position: Int) }
    private lateinit var itemClickListener: OnItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }
    class ItemViewHolder(view: View, itemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val userNameTV: TextView = view.findViewById(R.id.item_title)
        val lastMsgTV: TextView = view.findViewById(R.id.last_message)
        val timeTV: TextView = view.findViewById(R.id.item_time)
        val profilePicIV: ImageView = view.findViewById(R.id.item_image)

        init {
            view.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ItemViewHolder(adapterLayout, itemClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = userList[position]
        holder.userNameTV.text = user.name
        holder.lastMsgTV.text = user.lastMsg
        holder.timeTV.text = user.time
        holder.profilePicIV.setImageResource(user.profileImg)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}