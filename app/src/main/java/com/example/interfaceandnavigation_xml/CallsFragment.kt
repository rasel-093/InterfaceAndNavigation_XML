package com.example.interfaceandnavigation_xml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.interfaceandnavigation_xml.bottomsheet.BottomSheetFragment
import com.example.interfaceandnavigation_xml.listview.CallHistoryAdapter
import com.example.interfaceandnavigation_xml.model.randomCallHistoryList

class CallsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calls, container, false)

        val callHistoryListView = view.findViewById<ListView>(R.id.callHistoryListView)
        val activity = requireActivity()
        val adapter = CallHistoryAdapter(activity, requireContext(), R.layout.call_history_item, randomCallHistoryList)
        callHistoryListView.adapter = adapter
        return view
    }
}


