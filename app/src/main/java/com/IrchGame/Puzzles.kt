package com.IrchGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_puzzles.*

class Puzzles : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzles)
        (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION).also { window.decorView.systemUiVisibility = it }
        btn_store.init(Intent(this, com.IrchGame.StorePuzzle.Store_Main::class.java))
        btn_iceCream.init(Intent(this, Separation_Puzzle::class.java))
        btn_piramyde.init(Intent(this, shadows_puzzle::class.java))
    }
}