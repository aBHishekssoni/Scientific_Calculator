package com.abhishek_soni. scientificcalculator

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek_soni.scientificcalculator.data.CaculatorState
import com.abhishek_soni.scientificcalculator.data.CalculatorAction
import com.abhishek_soni.scientificcalculator.data.CalculatorOperation
import com.abhishek_soni.scientificcalculator.ui.theme.MediumGray
import com.abhishek_soni.scientificcalculator.ui.theme.Orange


@Composable
fun CalculatorButton(modifier: Modifier = Modifier,
                     symbol: String,
                     onClick: () -> Unit) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .clickable { onClick() }
        .then(modifier),
        contentAlignment = Alignment.Center) {
        Text(text = symbol,
            fontSize = 17.sp,
            color = White
        )
    }

}

@Composable
fun Calculator(modifier: Modifier = Modifier,
               state: CaculatorState,
               buttonSpacing: Dp=8.dp,
               onAction: (CalculatorAction)->Unit) {
    var more by remember { mutableStateOf(false) }
    if (more){
        Box(modifier = modifier.fillMaxSize().padding(5.dp)) {
            Column(modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter),

                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

//            if ((state.operation?.symbol ?:"+") as Boolean)
//            Text(
//                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
//                textAlign = TextAlign.End,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 50.dp),
//                fontWeight = FontWeight.Light,
//                fontSize = 80.sp,
//                color = MaterialTheme.colorScheme.onBackground,
//
//            )
//            else  if ((state.operation?.symbol ?:"%") as Boolean)
                Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 25.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground,

                )
                HorizontalDivider()
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "Sin",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Sin))
                        }
                    )
                    CalculatorButton(symbol = "Cos",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Cos))
                        }
                    )
                    CalculatorButton(symbol = "Tan",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Tan))
                        }
                    )
                    CalculatorButton(symbol = "Sin⁻¹",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Sin1))
                        }
                    )
                    CalculatorButton(symbol = "Cos⁻¹",
                        modifier = Modifier
                            .background(color = Orange)

                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Cos1))
                        }
                    )
                    CalculatorButton(symbol = "Tan⁻¹",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Tan1))
                        }
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "AC",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Clear)
                        }
                    )
                    CalculatorButton(symbol = "More",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            more = !more
                        }
                    )
                    CalculatorButton(symbol = "Del",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Delete)
                        }
                    )
                    CalculatorButton(symbol = "/",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    )
                    CalculatorButton(symbol = "^",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Pow))
                        }
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "7",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        }
                    )
                    CalculatorButton(symbol = "8",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(8))
                        }
                    )
                    CalculatorButton(symbol = "9",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(9))
                        }
                    )
                    CalculatorButton(symbol = "x",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.multiply))
                        }
                    )
                    CalculatorButton(symbol = "%",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Persent))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "4",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(4))
                        }
                    )
                    CalculatorButton(symbol = "5",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(5))
                        }
                    )
                    CalculatorButton(symbol = "6",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(6))
                        }
                    )
                    CalculatorButton(symbol = "—",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Substrct))
                        }
                    )
                    CalculatorButton(symbol = "ln",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.ln))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "1",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(1))
                        }
                    )
                    CalculatorButton(symbol = "2",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(2))
                        }
                    )
                    CalculatorButton(symbol = "3",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(3))
                        }
                    )
                    CalculatorButton(symbol = "+",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    )
                    CalculatorButton(symbol = "x²",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Square))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "0",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(0))
                        }
                    )
                    CalculatorButton(symbol = ".",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        }
                    )
                    CalculatorButton(symbol = "=",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        }
                    )
                    CalculatorButton(symbol = "√",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.SquareRoot))
                        }
                    )
                    CalculatorButton(symbol = "1/x",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Logic))
                        }
                    )
                }

            }

        }

    }
    else{
        Box(modifier = modifier.fillMaxSize().padding(5.dp)) {
            Column(modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter),

                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 25.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 40.sp,
                    color = White,
                    maxLines = 4
                )
                HorizontalDivider()

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "AC",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Clear)
                        }
                    )
                    CalculatorButton(symbol = "More",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            more = !more
                        }
                    )
                    CalculatorButton(symbol = "Del",
                        modifier = Modifier
                            .background(color = LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Delete)
                        }
                    )
                    CalculatorButton(symbol = "/",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "7",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        }
                    )
                    CalculatorButton(symbol = "8",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(8))
                        }
                    )
                    CalculatorButton(symbol = "9",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(9))
                        }
                    )
                    CalculatorButton(symbol = "x",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.multiply))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "4",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(4))
                        }
                    )
                    CalculatorButton(symbol = "5",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(5))
                        }
                    )
                    CalculatorButton(symbol = "6",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(6))
                        }
                    )
                    CalculatorButton(symbol = "—",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Substrct))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "1",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(1))
                        }
                    )
                    CalculatorButton(symbol = "2",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(2))
                        }
                    )
                    CalculatorButton(symbol = "3",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(3))
                        }
                    )
                    CalculatorButton(symbol = "+",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    )
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalculatorButton(symbol = "0",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = {
                            onAction(CalculatorAction.Number(0))
                        }
                    )
                    CalculatorButton(symbol = ".",
                        modifier = Modifier
                            .background(color = MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        }
                    )
                    CalculatorButton(symbol = "=",
                        modifier = Modifier
                            .background(color = Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        }
                    )
                }

            }

        }
    }

}
@Preview
@Composable
private fun CalculatorPreview() {
    Calculator(state = CaculatorState(), onAction = {})
}