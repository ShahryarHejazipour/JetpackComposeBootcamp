package com.example.jetpackcomposebootcamp.tipProject

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.tipProject.widgets.BillForm


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun MainContent() {

    Column(modifier = Modifier.padding(all = 12.dp)) {
        BillForm(){ billAmt ->
            Log.d("AMT", "MainContent: $billAmt")


        }
    }


}

