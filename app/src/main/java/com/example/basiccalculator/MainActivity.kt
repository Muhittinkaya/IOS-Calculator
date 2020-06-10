package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View){
        if(isNewOp){
            edtTextNumber.setText("")
        }
        isNewOp=false
        val btnSelected = view as Button
        var btnToWrite = edtTextNumber.text.toString()
        when(btnSelected.id){

            btn0.id ->{
                btnToWrite +="0"
            }
            btn1.id ->{
                btnToWrite +="1"
            }
            btn2.id ->{
                btnToWrite +="2"
            }
            btn3.id ->{
                btnToWrite +="3"
            }
            btn4.id ->{
                btnToWrite +="4"
            }
            btn5.id ->{
                btnToWrite +="5"
            }
            btn6.id ->{
                btnToWrite +="6"
            }
            btn7.id ->{
                btnToWrite +="7"
            }
            btn8.id ->{
                btnToWrite +="8"
            }
            btn9.id ->{
                btnToWrite +="9"
            }
            btndot.id ->{
                btnToWrite +="."
            }
            btnpdm.id ->{
                btnToWrite = "-$btnToWrite"
            }
        }
        edtTextNumber.setText(btnToWrite)

    }

    var op = "*"
    var oldnumber = ""
    var isNewOp = true

    fun btnOpEvent(view:View){

        val btnSelect = view as Button
        when(btnSelect.id){

            btndiv.id ->{
                op = "/"
            }
            btnminus.id ->{
                op = "-"
            }
            btnmultip.id ->{
                op = "*"
            }
            btnplus.id ->{
                op = "+"
            }
        }
        oldnumber = edtTextNumber.text.toString()
        isNewOp = true
    }

    fun btnEqual(view: View){
        val newNumber = edtTextNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*" -> finalNumber = oldnumber.toDouble() * newNumber.toDouble()
            "-" -> finalNumber = oldnumber.toDouble() - newNumber.toDouble()
            "+" -> finalNumber = oldnumber.toDouble() + newNumber.toDouble()
            "/" -> finalNumber = oldnumber.toDouble() / newNumber.toDouble()
        }
        edtTextNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun btnPercent(view: View){
        val number:Double = edtTextNumber.text.toString().toDouble()/100
        edtTextNumber.setText(number.toString())
        isNewOp=true
    }

    fun btnClean(view: View){
        edtTextNumber.setText("0")
        isNewOp=true
    }
}
