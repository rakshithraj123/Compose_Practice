package com.app.investcalculator.ui.mutalfund

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.investcalculator.data.model.Investment


@Composable
fun MutualFundScreen(investment: Investment? = Investment()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var principal by remember { mutableStateOf("") }
        var rateOfReturn by remember { mutableStateOf("") }
        var timePeriod by remember { mutableStateOf("") }

        investment?.let {
            Text(it.name)
            Spacer(modifier = Modifier.height(8.dp))
        }

        investment?.let {
            Text(it.details)
            Spacer(modifier = Modifier.height(8.dp))
        }

        TextField(
            value = principal,
            onValueChange = { principal = it },
            label = { Text("Principal Amount") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = rateOfReturn,
            onValueChange = { rateOfReturn = it },
            label = { Text("Rate of Return (%)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = timePeriod,
            onValueChange = { timePeriod = it },
            label = { Text("Time Period (years)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Implement the calculation logic here
        }) {
            Text("Calculate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MutualFundPreview() {
    MutualFundScreen()
}
