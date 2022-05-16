package com.example.android_course.views.signin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue


@Composable
fun SignIn(){
    var userEmail = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Sign In", textAlign = TextAlign.Center, modifier = Modifier.padding(bottom = 15.dp))


        Column(horizontalAlignment = Alignment.Start, modifier = Modifier
            .fillMaxWidth()) {

            CustomInput(userEmail, "Email" , true , false )

            CustomInput(password, "Password" , true , isPassword = true)

            CustomButon("Login", modifier = Modifier.padding(8.dp)) {
                println("LogIn")
            }
        }
    }

}

@Composable
fun CustomInput(valueInput: MutableState<String>, label: String, singleLine: Boolean, isPassword: Boolean){

    TextField(
        value = valueInput.value,
        onValueChange = {valueInput.value = it},
        label = { Text(label)},
        singleLine = singleLine,
        placeholder = { Text(label)},
        visualTransformation = if (isPassword){PasswordVisualTransformation()}else{VisualTransformation.None},
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            Icon(Icons.Filled.Add, "", tint = Blue)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Blue,
            unfocusedIndicatorColor = Color.Transparent
        )
    )

}

@Composable
fun CustomButon(text: String, modifier: Modifier, clicked: () -> Unit){
    Button(
        onClick = { clicked() },
        contentPadding = PaddingValues(10.dp),
        modifier = modifier,
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun SignInPreview(){
    SignIn()
}