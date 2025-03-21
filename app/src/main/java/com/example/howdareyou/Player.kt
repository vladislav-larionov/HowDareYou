package com.example.howdareyou

class Player(_name: String, _sex: String) {
    var name: String = _name
    var sex: String = _sex

    override fun toString(): String {
        return "$name - ${sex.get(0)}"
    }
}
