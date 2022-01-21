package com.example.project15k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project15k.R
import com.example.project15k.model.Member
import kotlinx.android.synthetic.main.item_member.view.*
import java.util.*

// this is a simple recycler view adapter
// recycler view foreground and background cell
class CustomAdapter(private val context: Context, private val itemList: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(
                context
            ).inflate(R.layout.item_member, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member: Member = itemList[position]

        // set data to item
        if (holder is CustomViewHolder) {
            holder.itemView.text_view_title.text = member.name
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class CustomViewHolder(
        view: View,
        val viewBackground: RelativeLayout = view.view_background,
        val viewForeground: RelativeLayout = view.view_foreground,
        val textView: TextView = view.text_view_title
    ) : RecyclerView.ViewHolder(view)
}