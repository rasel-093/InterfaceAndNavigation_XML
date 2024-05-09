package com.example.interfaceandnavigation_xml

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.model.Message

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)
        val intent = intent
        val userNo = intent.getIntExtra("position", -1)
//        val profileImg = findViewById<ImageView>(R.id.profile_img_chat)
//        val nameTv = findViewById<TextView>(R.id.name_tv_chat)
//        try {
//            profileImg.setImageResource(user[userNo].profileImg)
//            nameTv.text = user[userNo].name
//        }catch (e: ArrayIndexOutOfBoundsException){
//            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
//        }

        //Recyclerviw
        recyclerView = findViewById(R.id.chat_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChatAdapter(user[userNo].msg)

        //Send message
        val sendBtn = findViewById<ImageButton>(R.id.sendBtn)
        val messageEt = findViewById<TextView>(R.id.msgEt)

        sendBtn.setOnClickListener {
            if(messageEt.text.isEmpty()){
                Toast.makeText(this, "Please enter your message", Toast.LENGTH_SHORT).show()
            }else{
                user[userNo].msg.add(Message(0,messageEt.text.toString(), "2:00"))
                recyclerView.adapter?.notifyDataSetChanged()
                messageEt.text = null
            }
        }
    }
}