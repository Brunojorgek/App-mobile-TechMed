@file:OptIn(ExperimentalMaterial3Api::class)

package br.com.fiap.myapplication.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.fiap.myapplication.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {

    var email by remember() {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var isFocused by remember {
        mutableStateOf(false)
    }

    var loginError by remember {
        mutableStateOf(false)
    }

    val textFieldColors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Green)

    val tamanhoMaximo = 8

    Box() {
        Column(modifier = Modifier.padding(top = 70.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logotechmed),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(170.dp)
                        .padding(top = 14.dp)
                )
            }
            Column(
                modifier = Modifier
                    .background(Color.Gray)

            ) {

            }
            Spacer(modifier = Modifier.height(35.dp))
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .padding(end = 20.dp, start = 20.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White, focusedIndicatorColor = Color(
                        0xFF41DF41
                    )
                    ),
                    label = { Text(text = "Digite seu email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = ""
                            )
                        }
                    },
                    isError = emailError,
                )
                if (emailError) {
                    Text(
                        text = "O email é obrigatório!",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        color = Color.Red,
                        textAlign = TextAlign.End
                    )
                } else {

                }

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color(0xFF41DF41)
                    ),
                    value = password,
                    onValueChange = {
                        if (it.length <= tamanhoMaximo) password = it
                    },
                    modifier = Modifier.fillMaxWidth(),

                    label = { Text(text = "Digite sua senha") },

                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            androidx.compose.material3.Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        }
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                if (passwordError) {
                    Text(
                        text = "A senha é obrigatória!",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        color = Color.Red,
                        textAlign = TextAlign.End
                    )
                } else {

                }

            }


            //Spacer(modifier = Modifier.height(60.dp))
            Button(
                modifier = Modifier
                    .padding(end = 25.dp, start = 25.dp)
                    .background(Color(0xFF7BE37B)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7BE37B)),
                onClick = {
                    if (email.isEmpty()) {
                        emailError = true
                    }else if(password.isEmpty()){
                        passwordError = true
                    }else if(email != "admin" && password != "admin")
                        loginError = true
                    else {
                        navController.navigate("dashboard")
                    }


                }) {
                Text(
                    text = "Fazer Login",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            if (loginError) {
                Text(
                    text = "Email ou senha incorreta!",
                    modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.End
                )
            } else {

            }
        }
    }
}





