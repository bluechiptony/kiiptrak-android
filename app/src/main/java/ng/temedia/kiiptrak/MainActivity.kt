package ng.temedia.kiiptrak


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.temedia.kiiptrak.activities.DashboardActivity
import ng.temedia.kiiptrak.activities.ForgotPasswordActivity
import ng.temedia.kiiptrak.activities.SignUpActivity
import ng.temedia.kiiptrak.controls.LoginButton
import ng.temedia.kiiptrak.controls.LoginImageButton
import ng.temedia.kiiptrak.controls.TextViewModel
import ng.temedia.kiiptrak.controls.ValidatingInputTextField
import ng.temedia.kiiptrak.controls.ValidatingPasswordTextField
import ng.temedia.kiiptrak.ui.theme.KiiptrakTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KiiptrakTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    LoginActivityControls(loginMessage = "Kiiptrak", subText = "Login To Your Account")
                }
            }
        }
    }
}



@Composable
fun LoginActivityControls(loginMessage:String, subText:String, modifier: Modifier = Modifier){

    val context = LocalContext.current
    val textModel = TextViewModel()
    Column (verticalArrangement =Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(30.dp)){
        Text(text = loginMessage, fontSize = 50.sp, lineHeight = 60.sp, textAlign = TextAlign.Center)
        Text(text = subText, fontSize = 25.sp, textAlign = TextAlign.Center)
        ValidatingInputTextField( textLabel = "Username / Email", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ValidatingPasswordTextField( textLabel = "Password", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ForgotPasswordText()
        LoginButton(text = "LOGIN", onclick = {
             context.startActivity(Intent(context, DashboardActivity::class.java))
        })
        Spacer(modifier = Modifier.height(30.dp))
        LoginImageButton(textLabel = "Login with Google", onclick = { /*TODO*/ }, image = R.drawable.google_svgicon   , imageDescription = "Google icon")
        LoginImageButton(textLabel = "Login with Facebook", onclick = { /*TODO*/ }, image = R.drawable.facebook_svgicon   , imageDescription = "Facebook icon")
        SignUpText()
    }
}


@Composable
fun ForgotPasswordText(){
    val context = LocalContext.current
    Text(

        text = "Forgot Your Password", textAlign = TextAlign.End,

        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .clickable {
                context.startActivity(Intent(context, ForgotPasswordActivity::class.java))
            }

    )
}

@Composable
fun SignUpText(){
    val context = LocalContext.current
    Row(Modifier.padding(top = 50.dp)) {
        Text(
            text = "Or you can ", textAlign = TextAlign.End,
            fontSize = 14.sp,
            modifier = Modifier
        )

        Text(
            text = "Sign up here ", textAlign = TextAlign.End,
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.clickable {
                context.startActivity(Intent(context, SignUpActivity::class.java))
            },
            color = Color.Blue,
        )

    }

}




@Preview(showBackground = true)
@Composable
fun KiiptrakLoginPreview() {
    KiiptrakTheme {
        LoginActivityControls(loginMessage = "Kiiptrak", subText = "Login To Your Account")
    }
}