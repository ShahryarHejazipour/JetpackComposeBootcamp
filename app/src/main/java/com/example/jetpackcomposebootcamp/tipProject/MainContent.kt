package com.example.jetpackcomposebootcamp.tipProject

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.tipProject.widgets.BillForm


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {

    val splitByState = remember{
        mutableStateOf(3)
    }

    val tipAmountState = remember {

        mutableStateOf(0.0)
    }

    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }


    Column(modifier = Modifier.padding(all = 12.dp)) {
        BillForm(splitByState = splitByState,
            tipAmountState = tipAmountState,
            totalPerPersonState = totalPerPersonState){ billAmt ->
            Log.d("AMT", "MainContent: $billAmt")

        }


    }


}

