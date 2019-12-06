package com.mrjuoss.diceroller.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import com.mrjuoss.diceroller.R

class TimeFighterActivity : AppCompatActivity() {

    private lateinit var gameScoreTextView: TextView
    private lateinit var timeLeftTextView: TextView
    private lateinit var tapMeButton: Button

    private var score = 0
    private var gameStarted = false

    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown : Long = 6000
    private var coutDownInterval : Long = 1000
    private var timeLeft = 60


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)

        // Connect View to Variable
        gameScoreTextView = findViewById(R.id.txt_your_score)
        timeLeftTextView = findViewById(R.id.txt_time_left)
        tapMeButton = findViewById(R.id.tap_me_button)

        tapMeButton.setOnClickListener {
            incrementScore()
        }

    }

    private fun incrementScore() {
        // Increment Logic Score
        score ++
        val newScore = "Your Score : $score"
        gameScoreTextView.text = newScore
    }

    private fun resetGame() {
        // Reset Game Logic

    }

    private fun startGame() {
        // Start Game Logic

    }

    private fun endGame() {
        // End Game Logic
    }
}
