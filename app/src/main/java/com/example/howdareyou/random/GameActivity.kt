package com.example.howdareyou.random

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.howdareyou.Player
import com.example.howdareyou.R

class GameActivity : AppCompatActivity() {
    val players = ArrayList<Player>()
    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val arguments = intent.extras

        if (arguments != null) {
            val playersCount = arguments.getInt("playersCount")

            for (index in 0..playersCount-1) {

                val player1Name = arguments.getString("${index}_player")!!.split("_")[0]
                val player1Sex = arguments.getString("${index}_player")!!.split("_")[1]
                players.add(Player(player1Name, player1Sex))
            }
        }
        val mode = arguments!!.getString("mode")!!
        val actions = ArrayList<String>()
        val truths = ArrayList<String>()

        if (mode == "18") {
            truths.addAll(resources.getStringArray(R.array.question_truths18))
            actions.addAll(resources.getStringArray(R.array.question_actions18))
        }
        if (mode == "simple") {
            truths.addAll(resources.getStringArray(R.array.question_truths))
            actions.addAll(resources.getStringArray(R.array.question_actions))
        }
        game = Game(players, actions, truths)
        (findViewById(R.id.player) as TextView).setText("Сейчас отвечает: ${game.getCurPlayer()}")
    }

    fun getTruth(view: View) {
        (findViewById(R.id.task) as TextView).setText(game.getTruth())
    }

    fun getAction(view: View) {
        (findViewById(R.id.task) as TextView).setText(game.getAction())
    }

    fun next(view: View) {
        game.next()
        (findViewById(R.id.player) as TextView).setText("Сейчас отвечает: ${game.getCurPlayer()}")
        (findViewById(R.id.task) as TextView).setText("")
    }
}