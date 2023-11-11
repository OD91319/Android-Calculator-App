package com.example.calculators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var button1:android.widget.Button
    lateinit var button2:android.widget.Button
    lateinit var button3:android.widget.Button
    lateinit var button4:android.widget.Button
    lateinit var button5:android.widget.Button
    lateinit var button6:android.widget.Button
    lateinit var button7:android.widget.Button
    lateinit var button8:android.widget.Button
    lateinit var button9:android.widget.Button
    lateinit var button0:android.widget.Button
    lateinit var button00:android.widget.Button
    lateinit var buttonpercent:android.widget.Button
    lateinit var buttonclear:android.widget.Button
    lateinit var buttondot:android.widget.Button
    lateinit var buttonequal:android.widget.Button
    lateinit var buttonadd:android.widget.Button
    lateinit var buttonsub:android.widget.Button
    lateinit var buttonmul:android.widget.Button
    lateinit var buttondivide:android.widget.Button
    lateinit var buttonbackspace:android.widget.Button
lateinit var inbuttex:EditText
lateinit var result: EditText
lateinit var resutText:EditText
var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.button0)
        button00 = findViewById(R.id.button00)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9= findViewById(R.id.button9)
        buttonadd =findViewById(R.id.buttonadd)
        buttonequal= findViewById(R.id.buttonequal)
        buttonclear= findViewById(R.id.buttonB)
        buttondot=findViewById(R.id.buttondot)
        buttonpercent=findViewById(R.id.buttonp)
        buttonbackspace= findViewById(R.id.clear)
        buttonmul=findViewById(R.id.buttonmultiply)
        buttondivide=findViewById(R.id.buttonD)
        buttonequal=findViewById(R.id.buttonequal)
        result=findViewById(R.id.result)
        inbuttex=findViewById(R.id.inbutNumber)

        inbuttex.movementMethod= ScrollingMovementMethod()

        inbuttex.setActivated (true)
        inbuttex.setPressed (true)

        var text:String

        button1.setOnClickListener {
            text= inbuttex.text.toString()+"1"
            inbuttex.setText(text)
            result(text) }

        button2.setOnClickListener {
            text=inbuttex.text.toString()+"2"
            result(text) }

        button3.setOnClickListener {
            text= inbuttex.text.toString()+"3"
            inbuttex.setText(text)
            result(text) }

        button4.setOnClickListener {
            text= inbuttex.text.toString()+"4"
            inbuttex.setText(text)
            result(text) }

        button5.setOnClickListener {
            text= inbuttex.text.toString()+"5"
            inbuttex.setText(text)
            result(text) }

        button6.setOnClickListener {
            text= inbuttex.text.toString()+"6"
            inbuttex.setText(text)
            result(text) }

        button7.setOnClickListener {
            text= inbuttex.text.toString()+"7"
            inbuttex.setText(text)
            result(text) }

        button7.setOnClickListener {
            text= inbuttex.text.toString()+"7"
            inbuttex.setText(text)
            result(text) }

        button8.setOnClickListener {
            text= inbuttex.text.toString()+"8"
            inbuttex.setText(text)
            result(text) }

        button9.setOnClickListener {
            text= inbuttex.text.toString()+"9"
            inbuttex.setText(text)
            result(text) }
        button0.setOnClickListener {
            text= inbuttex.text.toString()+"0"
            inbuttex.setText(text)
            result(text) }

        button00.setOnClickListener {
            text= inbuttex.text.toString()+"00"
            inbuttex.setText(text)
            result(text) }
        buttondot.setOnClickListener {
            text= inbuttex.text.toString()+"."
            inbuttex.setText(text)
            result(text) }

        buttonmul.setOnClickListener {
            text = inbuttex.text.toString() + "*"
            inbuttex.setText(text)
            check = check +1}

        buttondivide.setOnClickListener {
            text = inbuttex.text.toString() + "/"
            inbuttex.setText(text)
            check = check +1}

        buttonpercent.setOnClickListener {
            text = inbuttex.text.toString() + "%"
            inbuttex.setText(text)
            check = check +1}

            buttonadd.setOnClickListener {
                text = inbuttex.text.toString() + "+"
                inbuttex.setText(text)
                check = check + 1
            }
        buttonequal.setOnClickListener {
            text=result.text.toString()
            inbuttex.setText(text)
            resutText.setText(null) }

        buttonclear.setOnClickListener {
            inbuttex.setText(null)
            resutText.setText(null) }

        buttonbackspace.setOnClickListener {
            var BackSpac:String?= null
            if (inbuttex.text.length>0) {
                val stringBuilder: StringBuilder = StringBuilder(inbuttex.text)
                val find = inbuttex.text.toString()
                val find2 = find.last()
                if (find2.equals('+') ||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%'))
                {
                    check=check-1
                }
      stringBuilder.deleteCharAt(inbuttex.text.length-1)
                BackSpac=stringBuilder.toString()
                inbuttex.setText(BackSpac)
                result(BackSpac)
                }
        }



    }

    private fun result(text: String) {
        val engine : ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result : Any=engine.eval(text)
            var mainr = result.toString()
            if (check==0)
            {
                resutText.setText(null)
            }
        else{
            resutText.setText(mainr)
            }
          }
    catch (e: ScriptException){
        Log.d("Tag","ERROR")
    }
    }


}