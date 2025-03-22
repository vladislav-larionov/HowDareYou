package com.example.howdareyou.random

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.howdareyou.Player
import com.example.howdareyou.R
import com.google.android.material.textfield.TextInputEditText

class CreatePlayers : AppCompatActivity() {
    val players = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_players)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner2: Spinner = findViewById(R.id.playersex)
        ArrayAdapter.createFromResource(
            baseContext,
            R.array.sex,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }

        val playersAdapter = PlayersAdapter(players)
        val recyclerView: RecyclerView = findViewById(R.id.pairsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = playersAdapter
    }

    fun addPlayer(view: View) {
        val player1Name = (findViewById(R.id.playerName) as TextInputEditText).text.toString()
        val player1Sex = (findViewById(R.id.playersex) as Spinner).selectedItem.toString()


        (findViewById(R.id.playerName) as TextInputEditText).setText("")
        (findViewById(R.id.playersex) as Spinner).setSelection(0)

        players.add(Player(player1Name, player1Sex))
        val imm = baseContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun startSimple(view: View) {
        if (players.size < 2)
            return
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("playersCount", players.size)
        intent.putExtra("mode", "simple")
        players.forEachIndexed { index, element ->
            intent.putExtra("${index}_player", "${element.name}_${element.sex}")
        }
        startActivity(intent)
    }

    fun start18(view: View) {
        if (players.size < 2)
            return
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("playersCount", players.size)
        intent.putExtra("mode", "18")
        players.forEachIndexed { index, element ->
            intent.putExtra("${index}_player", "${element.name}_${element.sex}")
        }
        startActivity(intent)
    }
}