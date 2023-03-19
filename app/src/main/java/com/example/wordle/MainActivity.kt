package com.example.wordle

import FourLetterWordList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var tries=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var wordToGuess=FourLetterWordList.getRandomFourLetterWord()
        val textView=findViewById<TextView>(R.id.answer)
        textView.text=wordToGuess
        val guessing=findViewById<EditText>(R.id.et_simple)

        val button= findViewById<Button>(R.id.button)


         fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        button.setOnClickListener{
            tries++

            if(tries<4){
                
                var strVal=guessing.text.toString().uppercase()
                var guessRes=checkGuess(strVal)
                if(tries==1){
                    val Gu=findViewById<TextView>(R.id.Check1)
                    val atCheck=findViewById<TextView>(R.id.Try1)
                    val Ch=findViewById<TextView>(R.id.Check1G)
                    val Gtxt=findViewById<TextView>(R.id.Result1)
                    Gu.visibility= View.VISIBLE
                    atCheck.visibility= View.VISIBLE
                    Ch.visibility= View.VISIBLE
                    Gtxt.visibility= View.VISIBLE
                    atCheck.text=strVal
                    Gtxt.text=guessRes

                }
                else if(tries==2){
                    val Gu=findViewById<TextView>(R.id.Check2)
                    val atCheck=findViewById<TextView>(R.id.Try2)
                    val Ch=findViewById<TextView>(R.id.Check2G)
                    val Gtxt=findViewById<TextView>(R.id.Result2)
                    Gu.visibility= View.VISIBLE
                    atCheck.visibility= View.VISIBLE
                    Ch.visibility= View.VISIBLE
                    Gtxt.visibility= View.VISIBLE
                    atCheck.text=strVal
                    Gtxt.text=guessRes

                }
                else if(tries==3){
                    button.text="Try again"
                    val Gu=findViewById<TextView>(R.id.Check3)
                    val atCheck=findViewById<TextView>(R.id.Try3)
                    val Ch=findViewById<TextView>(R.id.Check3G)
                    val Gtxt=findViewById<TextView>(R.id.Result3)
                    Gu.visibility= View.VISIBLE
                    atCheck.visibility= View.VISIBLE
                    Ch.visibility= View.VISIBLE
                    Gtxt.visibility= View.VISIBLE
                    atCheck.text=strVal
                    Gtxt.text=guessRes
                }
                if(guessRes=="OOOO") {
                    Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
                    button.text = "Try again"
                    tries = 4
                    textView.visibility=View.VISIBLE
                }
                if(guessRes!="OOOO"&&tries==3) {
                    Toast.makeText(this, "Sorry, Try Again", Toast.LENGTH_SHORT).show()
                    button.text = "Try again"
                    tries = 4
                    textView.visibility=View.VISIBLE
                }




                }
            else{
                textView.visibility=View.INVISIBLE
                var x="Test"
                tries=0
                wordToGuess=FourLetterWordList.getRandomFourLetterWord()
                textView.text=wordToGuess
                button.text="Submit"
                var Gu=findViewById<TextView>(R.id.Check1)
                var atCheck=findViewById<TextView>(R.id.Try1)
                var Ch=findViewById<TextView>(R.id.Check1G)
                var Gtxt=findViewById<TextView>(R.id.Result1)
                Gu.visibility= View.INVISIBLE
                atCheck.visibility= View.INVISIBLE
                Ch.visibility= View.INVISIBLE
                Gtxt.visibility= View.INVISIBLE

                Gu=findViewById<TextView>(R.id.Check2)
                atCheck=findViewById<TextView>(R.id.Try2)
                Ch=findViewById<TextView>(R.id.Check2G)
                Gtxt=findViewById<TextView>(R.id.Result2)
                Gu.visibility= View.INVISIBLE
                atCheck.visibility= View.INVISIBLE
                Ch.visibility= View.INVISIBLE
                Gtxt.visibility= View.INVISIBLE

                Gu=findViewById<TextView>(R.id.Check3)
                atCheck=findViewById<TextView>(R.id.Try3)
                Ch=findViewById<TextView>(R.id.Check3G)
                Gtxt=findViewById<TextView>(R.id.Result3)
                Gu.visibility= View.INVISIBLE
                atCheck.visibility= View.INVISIBLE
                Ch.visibility= View.INVISIBLE
                Gtxt.visibility= View.INVISIBLE

            }
            guessing.text.clear()

            }





        }
        //val guessRes=checkGuess(strVal)
    }

