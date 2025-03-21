package com.example.howdareyou

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.howdareyou.pairs.CreatePairActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTogetherClicked(view: View) {

    }
    fun onPairsClicked(view: View) {
        val intent = Intent(this, CreatePairActivity::class.java)
        startActivity(intent)
    }
}
