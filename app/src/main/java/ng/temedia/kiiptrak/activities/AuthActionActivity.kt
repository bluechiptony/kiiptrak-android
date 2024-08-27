package ng.temedia.kiiptrak.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.temedia.kiiptrak.R
import ng.temedia.kiiptrak.activities.ui.theme.KiiptrakTheme

class AuthActionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KiiptrakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthActionControls(
                        title = "Recover Your Account",
                        image = R.drawable.success_icon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AuthActionControls(title: String, @DrawableRes image: Int, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp)){
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            Modifier.size(15.dp)
        )
        Text(
            text = title,
            modifier = modifier,
            textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    KiiptrakTheme {
        AuthActionControls("Android", image =R.drawable.success_icon)
    }
}