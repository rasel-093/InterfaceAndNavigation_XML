package com.example.interfaceandnavigation_xml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.model.User
import com.example.interfaceandnavigation_xml.recyclerview.ItemAdapter

class ChatsFragment : Fragment() {
    //Recycler view
    private lateinit var recyclerView: RecyclerView
    private val userList: ArrayList<User> = userList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    val view = inflater.inflate(R.layout.fragment_chats, container, false)
    recyclerView = view.findViewById<RecyclerView>(R.id.chat_recycler_view)
    recyclerView.layoutManager = LinearLayoutManager(requireContext())


     recyclerView.setHasFixedSize(true)
     recyclerView.adapter = ItemAdapter(userList)
        return view
    }
}



fun userList(): ArrayList<User> {
    val userList = ArrayList<User>()
    val names = listOf("William", "John", "Emma", "Olivia", "Michael", "Sophia", "James", "Emily", "Benjamin", "Isabella")
    val lastMsgs = listOf("Hello", "Hi", "Hey", "What's up?", "How are you?", "Good morning", "Good evening")
    val times = listOf("1:00", "2:30", "4:15", "5:45", "10:20", "11:55")
    val profileImages = listOf(R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3, R.drawable.profile_4, R.drawable.profile_5)

    repeat(20) {
        val randomName = names.random()
        val randomLastMsg = lastMsgs.random()
        val randomTime = times.random()
        val randomProfileImg = profileImages.random()
        val user = User(it + 1, randomName, randomLastMsg, randomTime, randomProfileImg)
        userList.add(user)
    }

    return userList
}
