package com.bran.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    //variables globales
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operation: Int = 0

    // views

    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button
    private lateinit var ceroButton: Button
    private lateinit var pointButton: Button
    private lateinit var plusButton: Button
    private lateinit var multiButton: Button
    private lateinit var resultButton: Button
    private lateinit var restButton: Button
    private lateinit var divisionButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultText: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        onCLickButton()

    }


    //funcion que se encarga de conectar las views de arriba con los componentes del diseño segun su Id

    private fun bind(){

        oneButton = findViewById(R.id.oneButton)
        twoButton = findViewById(R.id.twoButton)
        threeButton = findViewById(R.id.threeButton)
        fourButton = findViewById(R.id.fourBotton)
        fiveButton = findViewById(R.id.fiveButton)
        sixButton = findViewById(R.id.sixButton)
        sevenButton = findViewById(R.id.sevenButton)
        eightButton = findViewById(R.id.eightButton)
        nineButton = findViewById(R.id.nineButton)
        ceroButton = findViewById(R.id.ceroButton)
        pointButton = findViewById(R.id.pointButton)
        plusButton = findViewById(R.id.plusButton)
        divisionButton = findViewById(R.id.divisioButton)
        restButton = findViewById(R.id.restButton)
        multiButton = findViewById(R.id.multiButton)
        resultButton = findViewById(R.id.resultButton)
        clearButton = findViewById(R.id.clearButton)
        resultText = findViewById(R.id.resultText)


    }

    private fun onCLickButton (){
        oneButton.setOnClickListener {numberPress("1")}
        twoButton.setOnClickListener {numberPress("2")}
        threeButton.setOnClickListener {numberPress("3")}
        fourButton.setOnClickListener {numberPress("4")}
        fiveButton.setOnClickListener {numberPress("5")}
        sixButton.setOnClickListener {numberPress("6")}
        sevenButton.setOnClickListener {numberPress("7")}
        eightButton.setOnClickListener {numberPress("8")}
        nineButton.setOnClickListener {numberPress("9")}
        ceroButton.setOnClickListener {numberPress("0")}


        // operaciones
        plusButton.setOnClickListener{operationPress(plusOp)}
        restButton.setOnClickListener{operationPress(restOp)}
        multiButton.setOnClickListener{operationPress(multiOp)}
        divisionButton.setOnClickListener{operationPress(divOp)}

        //aux
        clearButton.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultText.text = "0"
            operation = none
        }

        resultButton.setOnClickListener{
            var result = when(operation){
                plusOp -> num1 + num2
                restOp -> num1 - num2
                divOp -> num1 / num2
                multiOp -> num1 * num2
                else -> 0
            }
            resultText.text = result.toString()
        }

    }

    private fun numberPress(digit : String ) {
        resultText.text = "${resultText.text}$digit"

        if (operation == none) {
            num1 = resultText.text.toString().toDouble()
        } else
            num2 = resultText.text.toString().toDouble()
        }


    private fun operationPress (operation : Int){
        //
        this.operation = operation
        resultText.text = ""
    }

    companion object{
        const val plusOp = 1
        const val restOp = 2
        const val multiOp = 3
        const val divOp = 4
        const val none = 0
    }



}