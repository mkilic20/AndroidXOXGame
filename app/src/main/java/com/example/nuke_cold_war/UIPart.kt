package com.example.nuke_cold_war


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Map(){
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ){
        drawLine(
            color = Color.DarkGray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset( x = size.width * 1/3, y = 0f),
            end = Offset( x = size.width * 1/3, y = size.height)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset( x = size.width * 2/3, y = 0f),
            end = Offset( x = size.width * 2/3, y = size.height)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset( x = 0f, y = size.height*1/3),
            end = Offset( x = size.width, y = size.height*1/3)
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset( x = 0f, y = size.height*2/3),
            end = Offset( x = size.width, y = size.height*2/3)
        )
    }
}
/*commit deneme*/
@Composable
fun Cross(){
    Image(painter = painterResource(id = R.drawable.united_states), contentDescription = "Image",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth())
}


@Composable
fun Circle(){
    Image(painter = painterResource(id = R.drawable.soviet), contentDescription = "Image",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth())
}
@Composable
fun USWin(){
    Image(painter = painterResource(id = R.drawable.uswin), contentDescription = "Image",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth())
}
@Composable
fun SOVWin(){
    Image(painter = painterResource(id = R.drawable.sovwin), contentDescription = "Image",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth())
}
@Composable
fun Moon(){
    Image(painter = painterResource(id = R.drawable.moon), contentDescription = "Image",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth())
}
@Composable
fun Cuba(){
    Image(painter = painterResource(id = R.drawable.cuba), contentDescription = "Image",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth())
}
@Composable
fun Balkans(){
    Image(painter = painterResource(id = R.drawable.balkans), contentDescription = "Image",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth())
}
@Composable
fun Korea(){
    Image(painter = painterResource(id = R.drawable.korea), contentDescription = "Image",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth())
}
@Composable
fun Germany(){
    Image(painter = painterResource(id = R.drawable.germany), contentDescription = "Image",
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth())
}
@Composable
fun FinishLine(count : Float, type : String){
    if(type == "Vertical")
    {
        Canvas(modifier = Modifier.size(300.dp)){
            drawLine(
                color = Color.Black,
                strokeWidth = 50f,
                cap = StrokeCap.Round,
                start = Offset(x = size.width*count, y = 0f),
                end = Offset(x = size.width*count, y = size.height)
            )
        }
    }
    else if(type == "Horizontal")
    {
        Canvas(modifier = Modifier.size(300.dp)){
            drawLine(
                color = Color.Black,
                strokeWidth = 50f,
                cap = StrokeCap.Round,
                start = Offset(x = 0f, y = size.height*count),
                end = Offset(x = size.width, y = size.height*count)
            )
        }
    }
    else if(type == "Diagonal")
    {
        if(count == 0f)
        {
            Canvas(modifier = Modifier.size(300.dp)){
                drawLine(
                    color = Color.Black,
                    strokeWidth = 50f,
                    cap = StrokeCap.Round,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = size.height)
                )
            }
        }
        else
        {
            Canvas(modifier = Modifier.size(300.dp)){
                drawLine(
                    color = Color.Black,
                    strokeWidth = 50f,
                    cap = StrokeCap.Round,
                    start = Offset(x = 0f, y = size.height),
                    end = Offset(x = size.width, y = 0f)
                )
            }
        }
    }
}
@Composable
fun UIPart(
    viewGame: GameView
){
    var state = viewGame.state

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(text = "US : ${viewGame.crossCount}", fontSize = 20.sp)
            Text(text = "Draw : ${viewGame.drawCount}", fontSize = 20.sp)
            Text(text = "USSR : ${viewGame.circleCount}", fontSize = 20.sp)
        }
        Text(
            text = "Nuke Cold War",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.Red
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.White),
            contentAlignment = Alignment.Center
        )
        {
            if((viewGame.totalRound % 5) == 0){
                Moon()
            }
            else if((viewGame.totalRound % 5) == 1){
                Cuba()
            }
            else if((viewGame.totalRound % 5) == 2){
                Korea()
            }
            else if((viewGame.totalRound % 5) == 3){
                Germany()
            }
            else
            {
                Balkans()
            }
            Map()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            )
            {
                viewGame.allCells.forEach { (cellNo, valOfCell) ->
                    item{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable {
                                    if (cellNo == 1) {
                                        viewGame.isClicked1 = true
                                    }
                                    if (cellNo == 2) {
                                        viewGame.isClicked2 = true
                                    }
                                    if (cellNo == 3) {
                                        viewGame.isClicked3 = true
                                    }
                                    if (cellNo == 4) {
                                        viewGame.isClicked4 = true
                                    }
                                    if (cellNo == 5) {
                                        viewGame.isClicked5 = true
                                    }
                                    if (cellNo == 6) {
                                        viewGame.isClicked6 = true
                                    }
                                    if (cellNo == 7) {
                                        viewGame.isClicked7 = true
                                    }
                                    if (cellNo == 8) {
                                        viewGame.isClicked8 = true
                                    }
                                    if (cellNo == 9) {
                                        viewGame.isClicked9 = true
                                    }
                                    viewGame.isPressed()
                                    print("clicked")
                                    print(cellNo)

                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        )
                        {
                            AnimatedVisibility(visible = viewGame.allCells[cellNo] !=  Turns.NONE,
                                enter = scaleIn(tween(1000))
                            ) {


                                if(valOfCell == Turns.CIRCLE){
                                    Circle()
                                }
                                else if(valOfCell == Turns.CROSS){
                                    Cross()
                                }
                                if(viewGame.winner == GameView.WinnerLine.HOR1){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo ==1 || cellNo == 2|| cellNo == 3){
                                            USWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo ==1 || cellNo == 2|| cellNo == 3){
                                            SOVWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.HOR2){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 4 || cellNo == 5|| cellNo == 6){
                                            USWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 4 || cellNo == 5|| cellNo == 6){
                                            SOVWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.HOR3){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 7 || cellNo == 8|| cellNo == 9){
                                            USWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 7 || cellNo == 8|| cellNo == 9){
                                            SOVWin()
                                            FinishLine((0.5f),"Horizontal")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.VER1){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 7 || cellNo == 4|| cellNo == 1){
                                            USWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 7 || cellNo == 4|| cellNo == 1){
                                            SOVWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.VER2){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 8 || cellNo == 5|| cellNo == 2){
                                            USWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 8 || cellNo == 5|| cellNo == 2){
                                            SOVWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.VER3){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 9 || cellNo == 6|| cellNo == 3){
                                            USWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 9 || cellNo == 6|| cellNo == 3){
                                            SOVWin()
                                            FinishLine((0.5f),"Vertical")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.DIAG1){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 7 || cellNo == 5|| cellNo == 3){
                                            USWin()
                                            FinishLine((1f),"Diagonal")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 7 || cellNo == 5|| cellNo == 3){
                                            SOVWin()
                                            FinishLine((1f),"Diagonal")
                                        }
                                    }
                                }
                                if(viewGame.winner == GameView.WinnerLine.DIAG2){
                                    if(viewGame.allCells[cellNo] == Turns.CROSS){
                                        if(cellNo == 1 || cellNo == 5|| cellNo == 9){
                                            USWin()
                                            FinishLine((0f),"Diagonal")
                                        }
                                    }
                                    else
                                    {
                                        if(cellNo == 1 || cellNo == 5|| cellNo == 9){
                                            SOVWin()
                                            FinishLine((0f),"Diagonal")
                                        }
                                    }
                                }

                            }


                        }
                    }

                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = viewGame.turnText,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
            Button(
                onClick = {
                    viewGame.RestartButtonOn = true
                    viewGame.isPressed()
                },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            )
            {
                Text(text = "Restart the Game", fontSize = 16.sp)
            }
        }
    }
}


@Preview
@Composable
fun Prev(){
    UIPart(viewGame = GameView())
}