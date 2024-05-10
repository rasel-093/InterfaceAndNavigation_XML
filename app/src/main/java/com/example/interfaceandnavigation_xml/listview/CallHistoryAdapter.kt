package com.example.interfaceandnavigation_xml.listview

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.interfaceandnavigation_xml.R
import com.example.interfaceandnavigation_xml.model.CallHistoryItem

class CallHistoryAdapter(val activity: FragmentActivity, context: Context, resource: Int, private val callHistoryList: List<CallHistoryItem>) :
    ArrayAdapter<CallHistoryItem>(context, resource, callHistoryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.call_history_item, parent, false)
        }

        // Get the item for this position
        val callHistoryItem = callHistoryList[position]

        //Getting the views
        val callerProfileImageView = itemView!!.findViewById<ImageView>(R.id.callerPhotoImageView)
        val callerNameTextView = itemView.findViewById<TextView>(R.id.callerNameTextView)
        val calldateTextView = itemView.findViewById<TextView>(R.id.callDateTextView)
        val callTimeTextView = itemView.findViewById<TextView>(R.id.callTimeTextView)
        val returnCallImageBtn = itemView.findViewById<ImageButton>(R.id.callIconImageButton)

        //Setting the views values
        callerNameTextView.text = callHistoryItem.callerName
        calldateTextView.text = callHistoryItem.callDate
        callTimeTextView.text = callHistoryItem.callTime
        callerProfileImageView.setImageResource(callHistoryItem.callerProfile)

        //Creating alert Dialog
        val dialogBuilder = AlertDialog.Builder(this.context)
        val alertDialogLayout = LayoutInflater.from(this.context).inflate(R.layout.alert_dialog_layout, null)
        dialogBuilder.setView(alertDialogLayout)

        dialogBuilder.setNegativeButton("No"){dialog, which ->
            dialog.dismiss()
        }
        dialogBuilder.setPositiveButton("Yes"){dialog, which ->
            Toast.makeText(context, "Calling", Toast.LENGTH_SHORT).show()
        }
        val alertDialog = dialogBuilder.create()

        val dialogProfile = alertDialogLayout.findViewById<ImageView>(R.id.callerImage_in_dialog)
        val dialogName = alertDialogLayout.findViewById<TextView>(R.id.callerName_in_dialog)
        dialogProfile.setImageResource(callHistoryItem.callerProfile)
        dialogName.text = callHistoryItem.callerName

        returnCallImageBtn.setOnClickListener {
            alertDialog.show()
        }

        return itemView
    }
}
