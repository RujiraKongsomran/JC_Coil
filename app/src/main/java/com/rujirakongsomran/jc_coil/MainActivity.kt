package com.rujirakongsomran.jc_coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.rujirakongsomran.jc_coil.ui.theme.JC_CoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_CoilTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {

        val painter = rememberImagePainter(
            data = "https://cdn.pixabay.com/photo/2021/08/28/18/09/common-heather-6581569_960",
            builder = {
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
                crossfade(1000)
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo Image")
//        if (painterState is ImagePainter.State.Loading) {
//            CircularProgressIndicator()
//        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_CoilTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImage()
        }
    }
}