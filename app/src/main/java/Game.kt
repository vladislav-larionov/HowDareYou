import com.example.howdareyou.Player

class Game {
    var playerPairs: ArrayList<Pair<Player, Player>>
    var actions : ArrayList<String>
    var truths: ArrayList<String>
    var curPairIndex = 0
    var moves = ArrayList<Int>()

    constructor(players: ArrayList<Pair<Player, Player>>, _actions: ArrayList<String>, _truths: ArrayList<String>){
        playerPairs = players
        for (i in 0..playerPairs.size)
        {
            moves.add(0)
        }
        actions = _actions
        truths = _truths
    }

    public fun next() {
        if (curPairIndex + 1 >= playerPairs.size) {
            curPairIndex = 0
        } else {
            curPairIndex++
        }
        if (moves[curPairIndex] == 0) {
            moves[curPairIndex] = 1
        } else
            moves[curPairIndex] = 0
    }

    public fun getCurPlayer() : String {
        if (moves[curPairIndex] == 0)
             return playerPairs[curPairIndex].first.name
        else
             return playerPairs[curPairIndex].second.name
    }
    public fun getTruth() : String {
        return truths[(0..truths.size).random()]
    }
    public fun getAction() : String {
        return actions[(0..actions.size).random()]
    }
}