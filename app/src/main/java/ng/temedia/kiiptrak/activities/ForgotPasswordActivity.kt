package ng.temedia.kiiptrak.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.temedia.kiiptrak.controls.LoginButton
import ng.temedia.kiiptrak.controls.TextViewModel
import ng.temedia.kiiptrak.controls.ValidatingInputTextField
import ng.temedia.kiiptrak.ui.theme.KiiptrakTheme

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KiiptrakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ForgotPasswordControls(
                        title = "Recover Your Account",
                        subtext = "Forgot your password? \n" +
                                "No worries we weill help you out",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun ForgotPasswordControls(title: String, subtext:String,  modifier: Modifier = Modifier) {

    val textModel = TextViewModel()
    val context = LocalContext.current
    Column (verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp)){
        Text(
            text = title,
            modifier = modifier,
            fontSize = 50.sp, lineHeight = 50.sp, textAlign = TextAlign.Center
        )
        Text(
            text = subtext,
            modifier = modifier,
            textAlign = TextAlign.Center
        )

        ValidatingInputTextField( textLabel = "Email Address", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })

        LoginButton(text = "RECOVER MY ACCOUNT", onclick = {
            context.startActivity(Intent(context, SignUpActivity::class.java))
        })
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KiiptrakTheme {
        ForgotPasswordControls("Recover your account", subtext = "Forgot your password? \n No worries we weill help you out")
    }
}