package ng.temedia.kiiptrak.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import ng.temedia.kiiptrak.ForgotPasswordText
import ng.temedia.kiiptrak.R
import ng.temedia.kiiptrak.controls.LoginButton
import ng.temedia.kiiptrak.controls.LoginImageButton
import ng.temedia.kiiptrak.controls.TextViewModel
import ng.temedia.kiiptrak.controls.ValidatingInputTextField
import ng.temedia.kiiptrak.controls.ValidatingPasswordTextField
import ng.temedia.kiiptrak.ui.theme.KiiptrakTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KiiptrakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpControls(
                        title = "Sign up With us",
                        subtext = "Create an account with us \n" +
                                "Don't miss a thing",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpControls(title: String, subtext:String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val textModel = TextViewModel()

    Column (verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp)){
        Text(
            text = title,
            modifier = modifier,
            fontSize = 40.sp,  textAlign = TextAlign.Center
        )



        ValidatingInputTextField( textLabel = "First Name", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ValidatingInputTextField( textLabel = "Last Name", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ValidatingInputTextField( textLabel = "Email Address", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ValidatingInputTextField( textLabel = "Phone Number", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })

        LoginButton(text = "SIGN UP", onclick = {

        })

        Spacer(modifier = Modifier.height(30.dp))
        LoginImageButton(textLabel = "Sign up with Google", onclick = { /*TODO*/ }, image = R.drawable.google_svgicon   , imageDescription = "Google icon")
        LoginImageButton(textLabel = "Sign up with Facebook", onclick = { /*TODO*/ }, image = R.drawable.facebook_svgicon   , imageDescription = "Facebook icon")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KiiptrakTheme {
        SignUpControls("Sign up With us", subtext = "Create an account with us \n" +
                "Don't miss a thing")
    }
}