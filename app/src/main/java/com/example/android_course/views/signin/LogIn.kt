package com.example.android_course.views.signin

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_course.R
import com.example.android_course.ui.theme.MainOrange
import com.example.android_course.ui.theme.OpacityOrange


@Composable
fun LogIn(){
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_loginpana),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = "LOGIN",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
            )
            OrangeInput(username, true , Icons.Default.Person,"Username",false )
            OrangeInput(password, true , Icons.Default.Lock, "Password" , true )

            OrangeButon("Login", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp)){}

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Forgot password ?", style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold))
                Text("Skip", style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold))
            }
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text("Not Registred ?   ", style = TextStyle(fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Bold))
            Text("Create account", style = TextStyle(fontSize = 12.sp, color = MainOrange, fontWeight = FontWeight.Bold))
        }
    }
}

@Composable
fun OrangeInput(valueInput: MutableState<String>, singleLine: Boolean, icon: ImageVector,placeholder: String, isPassword: Boolean){

    TextField(
        value = valueInput.value,
        onValueChange = {valueInput.value = it},
        singleLine = singleLine,
        leadingIcon = { Icon(icon, "", tint = MainOrange, modifier = Modifier.size(18.dp)) } ,
        placeholder = { Text(placeholder, style = TextStyle(fontSize = 14.sp))},
        visualTransformation = if (isPassword){PasswordVisualTransformation()}else{VisualTransformation.None},
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .padding(bottom = 10.dp),
        shape = RoundedCornerShape(30.dp),
        textStyle = TextStyle(fontSize = 14.sp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = OpacityOrange,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )

}

@Composable
fun OrangeButon(text: String, modifier: Modifier, clicked: () -> Unit){
    Button(
        onClick = { clicked() },
        contentPadding = PaddingValues(15.dp),
        modifier = modifier,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MainOrange
        )
    ) {
        Text(text, style = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        )
    }
}

@Preview
@Composable
fun LogInPreview(){
    LogIn()
}