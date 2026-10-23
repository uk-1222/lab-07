package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController){
    var textInput by remember{ mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>()}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FormulaZero Drivers",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            TextField(
                value = textInput,
                onValueChange ={textInput = it},
                modifier = Modifier.weight(1f).testTag("textField")
            )
            Button(
                modifier = Modifier.padding(10.dp).testTag("addButton"),
                onClick = {
                    drivers.add(textInput)
                    textInput = ""
                }
            ){
                Text("Add Driver")
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth().height(300.dp).testTag("list")) {
            itemsIndexed(drivers){ index, driver ->
                Row(){
                    Text(text=driver)
                }
            }
        }
        Button(
            onClick = {drivers.clear()},
            modifier = Modifier.testTag("clearButton")
        ) { Text("Clear drivers")}

        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.testTag("homeButton") // for testing
        ) {
            Text("Return to Home Screen")
        }
    }
}