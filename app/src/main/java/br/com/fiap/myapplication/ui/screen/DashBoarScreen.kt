package br.com.fiap.myapplication.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myapplication.R
import br.com.fiap.myapplication.ui.theme.Green60
import br.com.fiap.myapplication.ui.theme.Grey20

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
data class Paciente(
    val card: String,
    val name: String,
    val plano: String
)

val paciente = Paciente(
    name = "Antonio",
    card = "1234",
    plano = "Prata II"
)


@Composable
fun DashboardScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        UserInfo(paciente)
        PlanoBox()
        Spacer(modifier = Modifier.height(20.dp))
        QRCodeBox()
        Spacer(modifier = Modifier.height(20.dp))
        BoxModel(
            title = "Últimos atendimentos",
            date = "11/11/2023",
            especialidade = "Cardiologista", "Dra Ana Maria"
        )
        Spacer(modifier = Modifier.height(20.dp))
        BoxModel2(
            title = "Agenda",
            date = "11/11/2023",
            especialidade = "Cardiologista", "José Alves da silva"
        )
        Spacer(modifier = Modifier.height(60.dp))

    }
    BottomBarDasboard(navController)
}

@Composable
fun PlanoBox() {
    Column(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(Green60),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Plano Médico",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight(600)
        )
        Text(
            paciente.plano,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}


@Composable
fun QRCodeBox() {
    val imageResource: Painter = painterResource(R.drawable.user)
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = Grey20
                )
        ) {
            Column {
                Image(
                    modifier = Modifier.height(60.dp),
                    painter = imageResource,
                    contentDescription = "Imagem de usuário"
                )
                Text(
                    "LER QRCode",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun BoxModel(
    title: String,
    date: String,
    especialidade: String,
    doutor: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(10.dp),
                    color = Grey20
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    )
            )
            {
                Row {
                    Text(
                        title, color = Green60,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(170.dp))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Seta para baixo",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(date)
                Box() {
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(
                                    0,
                                    15, 15,
                                    0
                                ),
                                color = Grey20
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Green60)
                                .fillMaxHeight()
                                .width(10.dp)
                        )
                        Text(especialidade, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(doutor)
                    }
                }
            }
        }
    }
}

@Composable
fun BoxModel2(
    title: String,
    date: String,
    especialidade: String,
    doutor: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(horizontal = 15.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp, shape = RoundedCornerShape(10.dp),
                    color = Grey20
                )
        ) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                Row {
                    Text(
                        title, color = Green60,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(170.dp))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Seta para baixo",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Box(modifier = Modifier.height(200.dp)) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(0, 15, 15, 0),
                                color = Grey20
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Green60)
                                .fillMaxHeight()
                                .width(10.dp)
                        )
                        Column {

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Icon(
                                    imageVector = Icons
                                        .Default.Done,
                                    contentDescription = "Seta para baixo",
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(date, modifier = Modifier.width(100.dp))
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Seta para baixo",
                                    modifier = Modifier.size(20.dp)
                                )
                                Text("10:30")
                            }
                            Column() {
                                Text(especialidade, fontWeight = FontWeight.Bold)
                                Text(doutor)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun UserInfo(paciente: Paciente) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier =
        Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color.White)
    ) {
        val imageResource: Painter = painterResource(R.drawable.user)
        Image(painter = imageResource, contentDescription = "Imagem de usuário")
        Column {
            Text("Olá ${paciente.card},", fontSize = 20.sp)
            Text("Cartão ${paciente.name}", fontSize = 20.sp)
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarDasboard(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), Arrangement.Bottom) {
        BottomAppBar(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(), containerColor = Green60
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = { navController.navigate("dashboard") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(30.dp)
                    )
                }

                IconButton(
                    onClick = { navController.navigate("marcarConsulta") }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Home",
                        modifier = Modifier.size(30.dp)
                    )
                }

                IconButton(
                    onClick = { navController.navigate("carteirinha") }
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Search",
                        modifier = Modifier.size(30.dp)

                    )

                }

                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.size(30.dp)

                    )
                }
            }

        }
    }
}
