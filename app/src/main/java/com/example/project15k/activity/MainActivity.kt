package com.example.project15k.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.project15k.R
import com.example.project15k.adapter.CustomAdapter
import com.example.project15k.helper.RecyclerItemTouchHelper
import com.example.project15k.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = recycler_view

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        val simpleCallback: ItemTouchHelper.SimpleCallback = RecyclerItemTouchHelper(
            0,
            ItemTouchHelper.LEFT,
            object : RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder?,
                    direction: Int,
                    position: Int
                ) {
                }
            })
        ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView)
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, members)
        recyclerView.adapter = customAdapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        val members: ArrayList<Member> = ArrayList<Member>()
        for (i in 1..100) {
            members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))
        }
        return members
    }
}


