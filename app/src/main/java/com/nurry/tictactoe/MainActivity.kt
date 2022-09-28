package com.nurry.tictactoe

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var gamePlace: RelativeLayout
    private lateinit var playerTv: TextView
    private var place: CharArray = CharArray(9)

    private var whoseTurn: Boolean = true
    private var isWin: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        gamePlace = findViewById(R.id.gamePlace)
        playerTv = findViewById(R.id.playerTv)
        val displayMetrics: DisplayMetrics = this@MainActivity.resources.displayMetrics
        for (i in 0 until gamePlace.childCount) {
            val plane: TextView = gamePlace.getChildAt(i) as TextView
            val params = gamePlace.getChildAt(i).layoutParams
            params.width = displayMetrics.widthPixels / 3
            params.height = displayMetrics.widthPixels / 3
            plane.layoutParams = params
            plane.text = null
            val finalI: Int = i
            plane.setOnClickListener {
                if(whoseTurn and !(place[finalI] == 'X' || place[finalI] == 'O') and !isWin){
                    place[finalI] = 'X'
                    plane.text = getText(R.string.X)
                    playerTv.text = getText(R.string.TurnO)
                    whoseTurn = !whoseTurn
                    isWin = winXCheck()
                }
                else if(!whoseTurn and !(place[finalI] == 'X' || place[finalI] == 'O') and !isWin){
                    place[finalI] = 'O'
                    plane.text = getText(R.string.O)
                    playerTv.text = getText(R.string.TurnX)
                    whoseTurn = !whoseTurn
                    isWin = winOCheck()
                }
            }
        }
        when(baseContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK){
            Configuration.UI_MODE_NIGHT_YES -> playerTv.setTextColor(getColor(R.color.white))
            Configuration.UI_MODE_NIGHT_NO -> playerTv.setTextColor(getColor(R.color.black))
            Configuration.COLOR_MODE_UNDEFINED -> playerTv.setTextColor(getColor(R.color.black))
        }
    }

    fun reset(view: View) {
        for(i in place.indices){
            place[i] = ' '
            val plane: TextView = gamePlace.getChildAt(i) as TextView
            plane.text = " "
        }
        isWin = false
        whoseTurn = true
        playerTv.text = getText(R.string.TurnX)
    }
    private fun winXCheck(): Boolean {
        val thisP = 'X'
        if (place[0] == thisP && place[1] == thisP && place[2] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[3] == thisP && place[4] == thisP && place[5] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[6] == thisP && place[7] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[0] == thisP && place[3] == thisP && place[6] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[1] == thisP && place[4] == thisP && place[7] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[2] == thisP && place[5] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[0] == thisP && place[4] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        } else if (place[2] == thisP && place[4] == thisP && place[6] == thisP) {
            playerTv.text = getString(R.string.WinX)
            return true
        }
        return false
    }

    private fun winOCheck(): Boolean {
        val thisP = 'O'
        if (place[0] == thisP && place[1] == thisP && place[2] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[3] == thisP && place[4] == thisP && place[5] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[6] == thisP && place[7] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[0] == thisP && place[3] == thisP && place[6] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[1] == thisP && place[4] == thisP && place[7] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[2] == thisP && place[5] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[0] == thisP && place[4] == thisP && place[8] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        } else if (place[2] == thisP && place[4] == thisP && place[6] == thisP) {
            playerTv.text = getString(R.string.WinO)
            return true
        }
        return false
    }

}