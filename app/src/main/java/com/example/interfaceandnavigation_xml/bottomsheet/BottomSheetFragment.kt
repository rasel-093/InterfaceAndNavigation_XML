package com.example.interfaceandnavigation_xml.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.interfaceandnavigation_xml.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment :  BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val bottomsheetbtn = view.findViewById<Button>(R.id.bottomSheetButton)
//        // Example button click listener
//        bottomsheetbtn.setOnClickListener {
//            dismiss() // Close the bottom sheet
//        }
    }
}
