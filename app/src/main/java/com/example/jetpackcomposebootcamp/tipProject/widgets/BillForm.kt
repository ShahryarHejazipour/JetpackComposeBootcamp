package com.example.jetpackcomposebootcamp.tipProject.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.tipProject.components.InputField
import com.example.jetpackcomposebootcamp.tipProject.utils.calculateTotalPerPerson
import com.example.jetpackcomposebootcamp.tipProject.utils.calculateTotalTip


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(modifier: Modifier = Modifier,
             onValChange:(String)-> Unit = {}) {


    //this state is for Checking VALUE of the something that enter in this TextField
    val totalBillState = remember{
        mutableStateOf("")
    }

    /*
    this state is for validation the something(in this case totalBillState state) that enter in this TextField
     */
    val validState = remember(totalBillState.value){

        totalBillState.value.trim().isNotEmpty()

    }

    val keyboardController = LocalSoftwareKeyboardController.current

    val sliderPositionState = remember{
        mutableStateOf(0f)
    }

    val tipPercentage = (sliderPositionState.value * 100).toInt()

    val splitByState = remember{
        mutableStateOf(3)
    }

    val range = IntRange(start = 1, endInclusive = 100)

    val tipAmountState = remember {

        mutableStateOf(0.0)
    }

    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }

    TopHeader( totalPerPerson = totalPerPersonState.value)


    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {

        Column(modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            InputField(
                valueState = totalBillState ,
                labelId = "Enter Bill",
                enabled = true ,
                isSingleLine = true,
                onAction = KeyboardActions{
                    if (!validState) return@KeyboardActions

                    onValChange(totalBillState.value.trim())

                    keyboardController?.hide()
                })
            if (validState){

                Row(modifier = Modifier.padding(3.dp), horizontalArrangement = Arrangement.Start) {
                    Text(text = "Split",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterVertically
                        ))

                    Spacer(modifier = Modifier.width(120.dp))

                    Row(modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End) {
                        RoundIconButton(imageVector = Icons.Default.Remove, onClick = {

                            splitByState.value =
                                if (splitByState.value>1) splitByState.value -1 else 1
                            totalPerPersonState.value =
                                calculateTotalPerPerson(totalBillState.value.toDouble(), splitBy = splitByState.value, tipPercentage = tipPercentage)


/*
                            if (splitByState.value > 1){
                                splitByState.value - 1

                            }else {

                                splitByState.value = 1

                            }*/

                        })
                        Text(text = "${splitByState.value}", modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 9.dp, end = 9.dp) )
                        RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                            if (splitByState.value < range.last)  splitByState.value += 1
                            totalPerPersonState.value =
                                calculateTotalPerPerson(totalBillState.value.toDouble(), splitBy = splitByState.value, tipPercentage = tipPercentage)
                        })

                    }

                }

                //Tip Row
                Row(modifier = Modifier.padding(horizontal = 3.dp, vertical = 12.dp)) {
                    Text(text = "Tip", modifier = Modifier
                        .align(alignment = Alignment.CenterVertically))
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "$ ${tipAmountState.value}", modifier = Modifier
                        .align(alignment = Alignment.CenterVertically))
                }

                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "% $tipPercentage")
                    Spacer(modifier = Modifier.height(14.dp))

                    //Slider
                    Slider(value = sliderPositionState.value, onValueChange = {newVal ->
                        sliderPositionState.value = newVal
                        tipAmountState.value =
                            calculateTotalTip(totalBill = totalBillState.value.toDouble(), tipPercentage = tipPercentage)
                        totalPerPersonState.value =
                            calculateTotalPerPerson(totalBillState.value.toDouble(), splitBy = splitByState.value, tipPercentage = tipPercentage)

                    }, modifier = Modifier.padding(start = 16.dp, end = 16.dp), steps = 5,
                        onValueChangeFinished = {})
                }

            }else{

                Box {


                }

            }
        }

    }


}
