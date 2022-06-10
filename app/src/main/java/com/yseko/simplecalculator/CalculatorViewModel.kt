package com.yseko.simplecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    var result by mutableStateOf(0)

    var operation by mutableStateOf("")
    var number by mutableStateOf("")

    var previous by mutableStateOf(0)
    //number: 0
    //operation: 1

    fun numberClicked(num: String){
        number+=num
        if(operation == "="){
            result = 0
        }
    }

    fun operationClicked(op: String){
        if(operation != ""){
            when(operation){
                "+" -> result += number.toInt()
                "-" ->result -= number.toInt()
                "*" -> result *= number.toInt()
                "/" -> result /= number.toInt()
                else ->{
                    result = result
                }
            }
        }else{
            result = number.toInt()
        }
        number = ""
        operation = op
    }

    fun deleteClicked(){
        println("delete")
    }

    fun plusminusClicked(){
        println("plusminus")
    }

    fun percentClicked(){
        println("percent")
    }

}