package com.example.supershop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.supershop.ui.SuperShopNavigation
import com.example.supershop.ui.home.HomeScreen
import com.example.supershop.ui.theme.SuperShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperShopApp()
                }
            }
        }
    }

    @Composable
    fun SuperShopApp() {
        SuperShopNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperShopTheme {

    }
}