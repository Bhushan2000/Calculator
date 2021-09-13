package com.example.calculator


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btn0: Button

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var btnMod: Button

    lateinit var btnClear: Button
    lateinit var btnBackspace: ImageButton
    lateinit var btnPoint: Button


    lateinit var btnEqual: Button

    lateinit var tvInput: TextView


    private val TAG = "MainActivity"

    var digit_on_screen = StringBuilder()
    var leftSide = 0.0
    var rightSide = 0.0
    var operation: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        btnMod = findViewById(R.id.btnMod)
        btnClear = findViewById(R.id.btnClear)

        btnBackspace = findViewById(R.id.btnBackspace)
        btnPoint = findViewById(R.id.btnPoint)


        btnEqual = findViewById(R.id.btnEqual)

        tvInput = findViewById(R.id.etInput)


    }

    private fun appendToDigitOnScreen(strToAdd: String) {
        digit_on_screen.append(strToAdd)
        tvInput.text = digit_on_screen.toString()

    }


    fun buttonZero(view: View) {

        appendToDigitOnScreen("0")
    }

    fun buttonOne(view: View) {


        appendToDigitOnScreen("1")

    }

    fun buttonTwo(view: View) {


        appendToDigitOnScreen("2")

    }

    fun buttonThree(view: View) {


        appendToDigitOnScreen("3")

    }

    fun buttonFour(view: View) {


        appendToDigitOnScreen("4")
    }

    fun buttonFive(view: View) {


        appendToDigitOnScreen("5")

    }

    fun buttonSix(view: View) {


        appendToDigitOnScreen("6")

    }

    fun buttonSeven(view: View) {


        appendToDigitOnScreen("7")

    }

    fun buttonEight(view: View) {


        appendToDigitOnScreen("8")

    }

    fun buttonNine(view: View) {


        appendToDigitOnScreen("9")

    }

    fun buttonAdd(view: View) {


        selectOperation('A')

    }


    fun buttonSub(view: View) {


        selectOperation('S')
    }

    fun buttonMul(view: View) {


        selectOperation('M')
    }

    fun buttonDiv(view: View) {


        selectOperation('D')
    }

    fun buttonMod(view: View) {

        selectOperation('O')
    }

    private fun selectOperation(c: Char) {
        try {
            operation = c
            leftSide = digit_on_screen.toString().toDouble()
            digit_on_screen.clear()
            tvInput.text = "0"
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun buttonPoint(view: View) {


        appendToDigitOnScreen(".")
    }

    fun buttonClear(view: View) {

        digit_on_screen.clear()
        tvInput.text = digit_on_screen.toString()

    }

    // this remove last digit from screen
    fun buttonBackspace(view: View) {
        clearDigits()

    }

    private fun clearDigits() {
        val length = digit_on_screen.length

        if (length >= 1) {

            digit_on_screen.deleteCharAt(length - 1)
        }

        tvInput.text = digit_on_screen.toString()
    }

    fun buttonEqual(view: View) {

        calculate()


    }

    private fun calculate() {
        try {
            rightSide = digit_on_screen.toString().toDouble()
            digit_on_screen.clear()


            when (operation) {
                'A' -> {
                    val sum = OperationHelper.add(leftSide, rightSide)
                    tvInput.text = sum.toString()
                    digit_on_screen.append(sum)

                }
                'S' -> {
                    val sub = OperationHelper.subtract(leftSide, rightSide)
                    tvInput.text = sub.toString()
                    digit_on_screen.append(sub)

                }
                'M' -> {
                    val mul = OperationHelper.multiply(leftSide, rightSide)
                    tvInput.text = mul.toString()
                    digit_on_screen.append(mul)


                }

                'D' -> {
                    val div = OperationHelper.divide(leftSide, rightSide)
                    tvInput.text = div.toString()
                    digit_on_screen.append(div)

                }
                'O' -> {
                    val mod = OperationHelper.mod(leftSide, rightSide)
                    tvInput.text = mod.toString()
                    digit_on_screen.append(mod)

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }


    }


}