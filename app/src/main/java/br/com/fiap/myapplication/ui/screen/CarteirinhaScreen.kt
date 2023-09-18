package br.com.fiap.myapplication.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.myapplication.R
import br.com.fiap.myapplication.ui.theme.Green20
import br.com.fiap.myapplication.ui.theme.Green60

@Composable
fun CarteirinhaScreen(navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
        ) {
            ReturnBar(navController)
        }
        Spacer(modifier = Modifier)
        Column(modifier = Modifier.fillMaxSize()) {
            val imageResource: Painter = painterResource(R.drawable.carteirinha)
            Image(
                modifier = Modifier
                    .width(450.dp)
                    .height(500.dp), painter = imageResource,
                contentDescription = "Carteirinha do usuário"
            )


        }


    }

    BottomBarCarteirinha(navController)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarCarteirinha(navController: NavController) {
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

