package com.example.homework4.ui.dashboard

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.homework4.R
import java.util.*
import kotlin.random.Random

private const val ID = "param_id"

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var button1: Button
    private lateinit var button2:Button
    private lateinit var textView: TextView
    private lateinit var main:View
    var count =0
    var currentColor: String? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()

        button1 = view?.findViewById(R.id.button)!!
        button2 = view?.findViewById(R.id.button2)!!
        textView = view?.findViewById(R.id.textView2)!!
        main = view?.findViewById(R.id.main)!!

        main.setBackgroundColor(randomColor())
        setTextForButton()
        button1.setOnClickListener {
            checkColorFirstButton()
        }
        button2.setOnClickListener {
            checkColorForSecondButton()
        }
    }

    private fun randomColor():Int{
        val randColor = Random
        return Color.rgb(
            randColor.nextInt(256),
            randColor.nextInt(256),
            randColor.nextInt(256))
    }

    private fun getHexCodeFromRandomColor():String{
        val hexCode = Integer.toHexString(randomColor())
        return hexCode
    }

    private fun randomValueForButton():Int{
        return Random.nextInt(0,2)
    }

    private fun setTextForButton(){
        when(randomValueForButton()){
            0 -> {button1.text = getHexCodeFromRandomColor()
                currentColor = button1.text as String
             button2.text = Integer.toHexString(Random.nextInt())}
            1 -> {button2.text = getHexCodeFromRandomColor()
                currentColor = button2.text as String
                button1.text = Integer.toHexString(Random.nextInt())
            }
        }
    }

    private fun checkColorFirstButton(){
        if (button1.text == currentColor){
            count+=1
        }else{
            count-=1
        }
        setTextForButton()
        textView.text = count.toString()
        main.setBackgroundColor(randomColor())
    }

    private fun checkColorForSecondButton(){
        if (button2.text == currentColor){
            count+=1
        }else{
            count-=1
        }
        setTextForButton()
        textView.text = count.toString()
        main.setBackgroundColor(randomColor())
    }

}