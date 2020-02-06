package com.example.hw1_numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var Number = 0
    private var guessCount = 0
    private var won = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resetEverything()
    }

    fun enterButton(view: View) {
        val guess = user_input.text.toString().toInt()
        guessCount++

        if (guessCount > 6 || won == 1) {
            message.text = "Reset to play again."
        } else {
            if (guess == Number) {
                message.text = "You won! " + Number + " is correct."
                won = 1
            } else if (guess < Number) {
                if (guessCount == 6) {
                    message.text = "Wrong, out of guesses, the number was " + Number + "."
                    hang()
                } else {
                    message.text = "Hint: Higher"
                    hang()
                }

            } else if (guess > Number) {
                if (guessCount == 6) {
                    message.text = "Out of guesses, the number was " + Number + "."
                    hang()
                } else {
                    message.text = "Hint: Lower"
                    hang()
                }
            }
        }
    }

    fun restartGame(view: View) {
        resetEverything()
    }

    fun resetEverything() {
        randomNumber()
        guessCount = 0
        won = 0
        message.text = ""

        head.setVisibility(View.INVISIBLE)
        body.setVisibility(View.INVISIBLE)
        leftArm.setVisibility(View.INVISIBLE)
        rightArm.setVisibility(View.INVISIBLE)
        leftLeg.setVisibility(View.INVISIBLE)
        rightLeg.setVisibility(View.INVISIBLE)

        guess1.text = ""
        guess2.text = ""
        guess3.text = ""
        guess4.text = ""
        guess5.text = ""
        guess6.text = ""
    }

    private fun randomNumber() {
        val randNum = Random().nextInt(100)
        Number = randNum
    }

    fun hang() {
        when (guessCount) {
            1 -> head.setVisibility(View.VISIBLE)
            2 -> body.setVisibility(View.VISIBLE)
            3 -> leftArm.setVisibility(View.VISIBLE)
            4 -> rightArm.setVisibility(View.VISIBLE)
            5 -> leftLeg.setVisibility(View.VISIBLE)
            6 -> rightLeg.setVisibility(View.VISIBLE)
            else -> ""
        }
        guessedNum()
    }

    fun guessedNum() {
        when (guessCount) {
            1 -> guess1.text = user_input.text.toString()
            2 -> guess2.text = user_input.text.toString()
            3 -> guess3.text = user_input.text.toString()
            4 -> guess4.text = user_input.text.toString()
            5 -> guess5.text = user_input.text.toString()
            6 -> guess6.text = user_input.text.toString()
            else -> ""

        }
    }
}
