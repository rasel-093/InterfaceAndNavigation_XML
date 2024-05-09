package com.example.interfaceandnavigation_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.model.Message

class ChatAdapter(
    private val msgList: ArrayList<Message>
): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val msgTv = itemView.findViewById<TextView>(R.id.msgTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ViewHolder {
        val adapterLaoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return ViewHolder(adapterLaoutInflater)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ViewHolder, position: Int) {
        val currentMsg = msgList[position]
        holder.msgTv.text = currentMsg.text
    }

    override fun getItemCount(): Int {
        return msgList.size
    }
}