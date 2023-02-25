package com.example.coinflip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coinflip.ui.theme.CoinFlipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinFlipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinApp("Android")
                }
            }
        }
    }
}


@Composable
fun CoinImage(flipNum: Int){
    when(flipNum){
        1 -> Image(painter = painterResource(id = R.drawable.coin_heads), contentDescription = stringResource(id = R.string.C1))
        2 -> Image(painter = painterResource(id = R.drawable.coin_tails), contentDescription = stringResource(id = R.string.C2))
    }

}



@Composable
fun CoinApp(name: String){
    var flip by remember{ mutableStateOf(1) }

    Column() {
        Row() {
            CoinImage(flip)

        }

        Button(onClick = {
            flip = (1..2).random()
        }){
            Text("Flip me")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinFlipTheme {
        CoinApp("Android")
    }
}