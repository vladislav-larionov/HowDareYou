package com.example.howdareyou.random

import com.example.howdareyou.Player

class Game {
    var players: ArrayList<Player>
    var actions : ArrayList<String>
    var truths: ArrayList<String>
    var curPlayerIndex = 0
    var moves = ArrayList<Int>()

    constructor(_players: ArrayList<Player>, _actions: ArrayList<String>, _truths: ArrayList<String>){
        players = _players
        for (i in 0..players.size)
        {
            moves.add(0)
        }
        actions = _actions
        truths = _truths
    }

    public fun next() {
        if (curPlayerIndex + 1 >= players.size) {
            curPlayerIndex = 0
        } else {
            curPlayerIndex++
        }
    }

    public fun getCurPlayer() : String {
        return players[curPlayerIndex].name
    }
    public fun getTruth() : String {
        return truths[(0..truths.size-1).random()]
    }
    public fun getAction() : String {
        return actions[(0..actions.size-1).random()]
    }
}