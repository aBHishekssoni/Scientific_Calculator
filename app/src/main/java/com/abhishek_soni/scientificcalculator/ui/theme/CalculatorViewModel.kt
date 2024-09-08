package com.abhishek_soni.scientificcalculator.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abhishek_soni.scientificcalculator.data.CaculatorState
import com.abhishek_soni.scientificcalculator.data.CalculatorAction
import com.abhishek_soni.scientificcalculator.data.CalculatorOperation
import kotlin.math.ln


class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CaculatorState())
        private set
    fun onAction(action: CalculatorAction){
        when(action){
            CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Clear -> state= CaculatorState()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.Number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorOperation.Operation -> TODO()
        }

    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank()->state= state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.number1.isNotBlank()->state= state.copy(
                number1 = state.number1.dropLast(1)
            )
            state.operation!=null->state= state.copy(
                operation = null
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1!=null && number2!=null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Substrct -> number1 - number2
                is CalculatorOperation.multiply -> number1 * number2
                CalculatorOperation.Cos -> Math.cos(number1)
                CalculatorOperation.Cos1 -> Math.acos(number1)
                CalculatorOperation.Logic -> 1/number1
                CalculatorOperation.Persent -> number1/100
                CalculatorOperation.Pow -> Math.pow(number1,number2)
                CalculatorOperation.Sin -> Math.sin(number1)
                CalculatorOperation.Sin1 -> Math.asin(number1)
                CalculatorOperation.Square -> Math.pow(number1,2.0)
                CalculatorOperation.SquareRoot -> Math.sqrt(number1)
                CalculatorOperation.Tan -> Math.tan(number1)
                CalculatorOperation.Tan1 -> Math.atan(number1)
                CalculatorOperation.ln -> ln(number1)
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(10),
                number2 = "",
                operation = null
            )
        }
    }


    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
        if (state.number1.isBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation ==null&&!state.number1.contains(".")&&state.number1.isNotBlank()){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".")&&state.number2.isNotBlank()){
            state = state.copy(
                number2 = state.number2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}