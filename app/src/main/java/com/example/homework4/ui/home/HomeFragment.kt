package com.example.homework4.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4.AdapterRes
import com.example.homework4.ColorsPuncts
import com.example.homework4.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()
        var list = ArrayList<ColorsPuncts>()
        list.add(ColorsPuncts(Color.WHITE,"white"))
        list.add(ColorsPuncts(Color.BLUE,"Blue"))
        list.add(ColorsPuncts(Color.BLACK,"black"))
        list.add(ColorsPuncts(Color.GREEN,"green"))
        list.add(ColorsPuncts(Color.YELLOW,"yellow"))
        list.add(ColorsPuncts(Color.RED,"red"))
        list.add(ColorsPuncts(Color.TRANSPARENT,"transpatent"))
        list.add(ColorsPuncts(Color.LTGRAY,"graylt"))
        list.add(ColorsPuncts(Color.DKGRAY,"gray"))

        recyclerView = view?.findViewById<RecyclerView>(R.id.my_recycler)!!
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.adapter = AdapterRes(context,list)
    }

}