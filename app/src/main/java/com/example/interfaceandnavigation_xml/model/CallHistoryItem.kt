package com.example.interfaceandnavigation_xml.model

import com.example.interfaceandnavigation_xml.R
import kotlin.random.Random

data class CallHistoryItem(
    val id: Int,
    val callDate: String,
    val callTime: String,
    val callerName: String,
    val callerProfile: Int
)



// Function to generate a random call date
fun generateRandomCallDate(): String {
    val day = Random.nextInt(1, 32)
    val month = Random.nextInt(1, 13)
    val year = Random.nextInt(2020, 2025)
    return "$month/$day/$year"
}

// Function to generate a random call time
fun generateRandomCallTime(): String {
    val hour = Random.nextInt(0, 24)
    val minute = Random.nextInt(0, 60)
    return String.format("%02d:%02d", hour, minute)
}

// Function to generate a random caller name
fun generateRandomCallerName(): String {
    val names = listOf("John", "Jane", "Alice", "Bob", "Emma", "Michael")
    return names.random()
}

// Function to generate a random caller profile
fun generateRandomCallerProfile(): Int {
    val profilePics = listOf(R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3, R.drawable.profile_4, R.drawable.profile_5)
    return profilePics.random()
}

// Function to generate a random list of CallHistoryItem objects
fun generateRandomCallHistoryList(size: Int): List<CallHistoryItem> {
    val callHistoryList = mutableListOf<CallHistoryItem>()
    for (i in 1..size) {
        val callHistoryItem = CallHistoryItem(
            id = i,
            callDate = generateRandomCallDate(),
            callTime = generateRandomCallTime(),
            callerName = generateRandomCallerName(),
            callerProfile = generateRandomCallerProfile()
        )
        callHistoryList.add(callHistoryItem)
    }
    return callHistoryList
}

// Usage
val randomCallHistoryList = generateRandomCallHistoryList(10) // Generate a list of 10 random CallHistoryItem objects

