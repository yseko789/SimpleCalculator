package com.yseko.simplecalculator

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yseko.simplecalculator.ui.theme.SimpleCalculatorTheme
import org.intellij.lang.annotations.JdkConstants

import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}

@Composable
fun CalculatorButton(
    @StringRes symbol: Int,
    @ColorRes color: Int,
    onClick: (String)->Unit,
    modifier: Modifier = Modifier
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(colorResource(id = color))
            .clickable { onClick() }
    ){
        Text(
            text = stringResource(id = symbol)
        )
    }
}

@Composable
fun CalculatorButtons(
    onNumClick: (String)->Unit,
    onOpClick: (String)->Unit,
    onDeleteClick: ()->Unit,
    onPlusMinusClicked: ()->Unit,
    onPercentClicked: ()->Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            CalculatorButton(
                symbol = R.string.delete,
                color = R.color.calcLightGray,
                onClick=onDeleteClick,
                modifier= Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.plusminus,
                color = R.color.calcLightGray,
                onClick=onPlusMinusClicked,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.percent,
                color = R.color.calcLightGray,
                onClick = onPercentClicked,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.divide,
                color = R.color.calcOrange,
                onClick=onOpClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            CalculatorButton(
                symbol = R.string.seven,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.eight,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.nine,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.multiply,
                color = R.color.calcOrange,
                onClick = onOpClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            CalculatorButton(
                symbol = R.string.four,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.five,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.six,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.minus,
                color = R.color.calcOrange,
                onClick = onOpClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
        ) {
            CalculatorButton(
                symbol = R.string.one,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.two,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.three,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)

            )
            CalculatorButton(
                symbol = R.string.plus,
                color = R.color.calcOrange,
                onClick = onOpClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            CalculatorButton(
                symbol = R.string.zero,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier = modifier
                    .weight(2f)
                    .aspectRatio(2f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.decimal,
                color = R.color.calcDarkGray,
                onClick = onNumClick,
                modifier = modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
            CalculatorButton(
                symbol = R.string.equal,
                color = R.color.calcOrange,
                onClick = onOpClick,
                modifier= modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
            )
        }
    }
}



@Composable
fun Display(
    modifier: Modifier = Modifier
){
    Text(
        text = "here",
        textAlign = TextAlign.End,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    calcViewModel: CalculatorViewModel = viewModel()
){
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Display()
        CalculatorButtons(
            onNumClick = {}


        )
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleCalculatorTheme {
        CalculatorButton(R.string.zero, R.color.purple_200, Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun buttonsPreview(){
    SimpleCalculatorTheme {
        CalculatorButtons()
    }
}