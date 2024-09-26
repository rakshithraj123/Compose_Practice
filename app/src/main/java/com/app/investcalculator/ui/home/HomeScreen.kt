package com.app.investcalculator.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.investcalculator.data.model.Investment

@Composable
fun HomeScreen(navigateToMutualFundScreen: (investment : Investment) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center

    ) {
        CalculateButton(onClick = { navigateToMutualFundScreen(Investment("Mutual Fund","Mutual Fund Calculator")) }, name = "Mutual Fund Calculator" )

        Spacer(modifier = Modifier.height(16.dp))

        CalculateButton(onClick = { } , name = "NPS Calculator" )

        Spacer(modifier = Modifier.height(16.dp))

        CalculateButton(onClick = { } , name = "Shares Calculator" )

        Spacer(modifier = Modifier.height(16.dp))

        CalculateButton(onClick = { } , name = "EMI Calculator" )
    }
}

@Composable
fun CalculateButton(name : String = "button" , onClick : ()-> Unit = {},modifier : Modifier = Modifier){
    Button(onClick = onClick ,modifier = modifier.fillMaxWidth()) {
        Text(name)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen {}
}