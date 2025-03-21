package com.example.howdareyou

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class CreatePairActivity : AppCompatActivity() {
    val playerPairs = ArrayList<Pair<Player, Player>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pair)

        val spinner1: Spinner = findViewById(R.id.player1sex)
        ArrayAdapter.createFromResource(
            baseContext,
            R.array.sex,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.player2sex)
        ArrayAdapter.createFromResource(
            baseContext,
            R.array.sex,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }

        val playersAdapter = PlayersAdapter(playerPairs)
        val recyclerView: RecyclerView = findViewById(R.id.pairsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = playersAdapter

    }

    fun addPair(view: View) {
        val player1Name = (findViewById(R.id.player1Name) as TextInputEditText).text.toString()
        val player1Sex = (findViewById(R.id.player1sex) as Spinner).selectedItem.toString()
        val player2Name = (findViewById(R.id.player2Name) as TextInputEditText).text.toString()
        val player2Sex = (findViewById(R.id.player2sex) as Spinner).selectedItem.toString()


        (findViewById(R.id.player1Name) as TextInputEditText).setText("")
        (findViewById(R.id.player1sex) as Spinner).setSelection(0)
        (findViewById(R.id.player2Name) as TextInputEditText).setText("")
        (findViewById(R.id.player2sex) as Spinner).setSelection(0)

        playerPairs.add(Pair(Player(player1Name, player1Sex), Player(player2Name, player2Sex)))
        val imm = baseContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun startGame(view: View) {}
}