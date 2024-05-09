package com.example.interfaceandnavigation_xml

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaceandnavigation_xml.model.Message
import com.example.interfaceandnavigation_xml.model.User
import com.example.interfaceandnavigation_xml.recyclerview.ChatUserListAdapter


class ChatsFragment : Fragment() {
    //Recycler view
    private lateinit var recyclerView: RecyclerView
    private val userList: ArrayList<User> = user

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.chat_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        val adapter = ChatUserListAdapter(userList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object: ChatUserListAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), ChatActivity::class.java)
                intent.putExtra("position", position)
                startActivity(intent)
            }
        })

        return view
    }
}

val user = userList()
fun userList(): ArrayList<User> {
    val userList = ArrayList<User>()
    val names = listOf(
        "William",
        "John",
        "Emma",
        "Olivia",
        "Michael",
        "Sophia",
        "James",
        "Emily",
        "Benjamin",
        "Isabella"
    )
    val lastMsgs =
        listOf("Hello", "Hi", "Hey", "What's up?", "How are you?", "Good morning", "Good evening")
    val times = listOf("1:00", "2:30", "4:15", "5:45", "10:20", "11:55")
    val profileImages = listOf(
        R.drawable.profile_1,
        R.drawable.profile_2,
        R.drawable.profile_3,
        R.drawable.profile_4,
        R.drawable.profile_5
    )

    val msgList = generateRandomMessages()

    repeat(20) {
        val randomName = names.random()
        val randomLastMsg = lastMsgs.random()
        val randomTime = times.random()
        val randomProfileImg = profileImages.random()
        val user = User(it + 1, randomName, randomLastMsg, randomTime, randomProfileImg, msgList)
        userList.add(user)
    }

    return userList
}


fun generateRandomMessages(): ArrayList<Message> {
    val messages = arrayListOf<Message>()
    val contents = listOf(
        "Hello",
        "Hi there!",
        "How are you?",
        "What's up?",
        "Good morning!",
        "Good afternoon!",
        "Good evening!",
        "Nice to meet you!",
        "See you later!",
        "Have a great day!"
    )
    val times = listOf("1:00", "2:30", "4:45", "9:15", "10:30", "12:00")

    repeat(10) { id ->
        val content = contents.random()
        val time = times.random()
        val message = Message(id + 1, content, time)
        messages.add(message)
    }

    return messages
}
