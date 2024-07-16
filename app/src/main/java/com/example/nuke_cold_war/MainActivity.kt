package com.example.nuke_cold_war


import com.example.nuke_cold_war.ui.theme.Nuke_Cold_WarTheme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



data class GameState(

    val curTurn: Turns = Turns.CROSS,
)
enum class Turns{
    CIRCLE,
    CROSS,
    NONE
}


class GameView: ViewModel() {
    var winner: WinnerLine = WinnerLine.NONE
    enum class WinnerLine{
        HOR1,
        HOR2,
        HOR3,
        VER1,
        VER2,
        VER3,
        DIAG1,
        DIAG2,
        NONE
    }
    var state by mutableStateOf(GameState())
    var drawCount: Int = 0
    var circleCount: Int = 0
    var crossCount: Int = 0
    var totalCircle: Int = 0
    var totalCross: Int = 0
    var isFin: Boolean = false
    var turnText: String = "US's Turn"
    var RestartButtonOn = false
    var isClicked1 = false
    var isClicked2 = false
    var isClicked3 = false
    var isClicked4 = false
    var isClicked5 = false
    var isClicked6 = false
    var isClicked7 = false
    var isClicked8 = false
    var isClicked9 = false
    var totalRound = 0
    val allCells: MutableMap<Int, Turns> = mutableMapOf(
        1 to Turns.NONE,
        2 to Turns.NONE,
        3 to Turns.NONE,
        4 to Turns.NONE,
        5 to Turns.NONE,
        6 to Turns.NONE,
        7 to Turns.NONE,
        8 to Turns.NONE,
        9 to Turns.NONE,
    )
    fun isPressed()
    {
        if(RestartButtonOn)
        {
            restartGame()
            RestartButtonOn = false;
        }
        if(isClicked1)
        {
            assignMove(1)
            isClicked1 = false
        }
        if(isClicked2)
        {
            assignMove(2)
            isClicked2 = false
        }
        if(isClicked3)
        {
            assignMove(3)
            isClicked3 = false
        }
        if(isClicked4)
        {
            assignMove(4)
            isClicked4 = false
        }
        if(isClicked5)
        {
            assignMove(5)
            isClicked5 = false
        }
        if(isClicked6)
        {
            assignMove(6)
            isClicked6 = false
        }
        if(isClicked7)
        {
            assignMove(7)
            isClicked7 = false
        }
        if(isClicked8)
        {
            assignMove(8)
            isClicked8 = false
        }
        if(isClicked9)
        {
            assignMove(9)
            isClicked9 = false
        }
    }

    private fun restartGame() {
        allCells.forEach { (a, _) ->
            allCells[a] = Turns.NONE
        }

        state = state.copy(
            curTurn = Turns.CROSS,

            )
        winner = WinnerLine.NONE
        turnText = "US's turn"
        isFin = false
        totalCross = 0
        totalCircle = 0
        totalRound = totalRound + 1
    }

    private fun assignMove(cellNo: Int) {

        if(allCells[cellNo] != Turns.NONE) {
            return
        }
        if(state.curTurn == Turns.CIRCLE){

            allCells[cellNo] = Turns.CIRCLE
            totalCircle = totalCircle + 1
            if(isWon(Turns.CIRCLE)){
                state = state.copy(

                    curTurn = Turns.NONE,

                    )
                turnText = "USSR Won"
                circleCount = circleCount + 1
                isFin = true
            }
            else if(isFull()) {
                state = state.copy(

                    curTurn = Turns.NONE,

                    )
                turnText = "DRAW"
                drawCount = drawCount+1
                isFin = true

            }
            /*commit test*/
            else{
                state = state.copy(

                    curTurn = Turns.CROSS
                )
                turnText = "US's Turn"

            }
            /*commit deneme*/

        }
        else if(state.curTurn == Turns.CROSS){
            allCells[cellNo] = Turns.CROSS
            totalCross = totalCross + 1
            if(isWon(Turns.CROSS)){
                state = state.copy(
                    curTurn = Turns.NONE,

                    )
                turnText = "US Won"
                crossCount = crossCount + 1
                isFin = true
            }
            else if(isFull()) {
                state = state.copy(

                    curTurn = Turns.NONE,

                    )
                turnText = "DRAW"
                drawCount = drawCount+1
                isFin = true
            }
            else{
                state = state.copy(
                    curTurn = Turns.CIRCLE
                )
                turnText = "USSR's Turn"

            }

        }
    }

    private fun isWon(valCell: Turns): Boolean {
        when{
            allCells[1] == valCell && allCells[2] == valCell && allCells[3] == valCell ->{
                winner = WinnerLine.HOR1
                /*if(valCell == Turns.CIRCLE)
                {
                    allCells[1] = Turns.USWIN
                    allCells[2] = Turns.USWIN
                    allCells[3] = Turns.USWIN
                }*/
                return true
            }
            allCells[4] == valCell && allCells[5] == valCell && allCells[6] == valCell ->{
                winner = WinnerLine.HOR2
                return true
            }
            allCells[7] == valCell && allCells[8] == valCell && allCells[9] == valCell ->{
                winner = WinnerLine.HOR3
                return true
            }
            allCells[1] == valCell && allCells[4] == valCell && allCells[7] == valCell ->{
                winner = WinnerLine.VER1
                return true
            }
            allCells[2] == valCell && allCells[5] == valCell && allCells[8] == valCell ->{
                winner = WinnerLine.VER2
                return true
            }
            allCells[3] == valCell && allCells[6] == valCell && allCells[9] == valCell ->{
                winner = WinnerLine.VER3
                return true
            }
            allCells[7] == valCell && allCells[5] == valCell && allCells[3] == valCell ->{
                winner = WinnerLine.DIAG1
                return true
            }
            allCells[1] == valCell && allCells[5] == valCell && allCells[9] == valCell ->{
                winner = WinnerLine.DIAG2
                return true
            }
            else -> return false
        }
    }

    private fun isFull(): Boolean {
        if(totalCross+totalCircle >= 9){
            isFin = true
            return true
        }
        else{
            return false
        }
    }
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nuke_Cold_WarTheme {

                val viewMode = viewModel<GameView>()
                UIPart(viewGame = viewMode)
            }
        }
    }
}