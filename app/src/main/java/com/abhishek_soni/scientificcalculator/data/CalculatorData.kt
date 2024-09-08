package com.abhishek_soni.scientificcalculator.data




sealed class CalculatorOperation(val symbol: String){
    object Add: CalculatorOperation("+")
    object Substrct: CalculatorOperation("-")
    object multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
    object Logic: CalculatorOperation("1/x")
    object SquareRoot: CalculatorOperation("√")
    object Square: CalculatorOperation("²")
    object Sin: CalculatorOperation("sin")
    object Cos: CalculatorOperation("cos")
    object Tan: CalculatorOperation("tan")
    object Sin1: CalculatorOperation("sin⁻¹")
    object Cos1: CalculatorOperation("cos⁻¹")
    object Tan1: CalculatorOperation("tan⁻¹")
    object Persent: CalculatorOperation("%")
    object Pow: CalculatorOperation("^")
    object ln: CalculatorOperation("ln")
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}

sealed class CalculatorAction{
    data class Number(val Number:Int): CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()

}


data class CaculatorState (
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null

)
