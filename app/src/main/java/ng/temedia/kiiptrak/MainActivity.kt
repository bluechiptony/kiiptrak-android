package ng.temedia.kiiptrak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
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

class TextViewModel:ViewModel(){
    var text by mutableStateOf("")
        private set
    fun updateText(passedText:String){
        text = passedText
    }
}


@Composable
fun LoginActivityControls(loginMessage:String, subText:String, modifier: Modifier = Modifier){
    modifier.padding(all = 50.dp)
    val textModel = TextViewModel()
    Column (verticalArrangement =Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = loginMessage, fontSize = 50.sp, lineHeight = 60.sp, textAlign = TextAlign.Center)
        Text(text = subText, fontSize = 25.sp, textAlign = TextAlign.Center)
        ValidatingInputTextField( textLabel = "Username / Email", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ValidatingPasswordTextField( textLabel = "Password", textValue =  textModel.text, updateState = { input-> textModel.updateText(input) })
        ForgotPasswordText()
        LoginButton(text = "Login", onclick = { /*TODO*/ })
    }
}

@Composable
fun LoginButton(text:String, onclick:()-> Unit){
    Button(
        onClick = { onclick() },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}


@Composable
fun ValidatingInputTextField( textLabel:String, updateState:(String) -> Unit , textValue:String){
    OutlinedTextField(
        value = textValue,
        onValueChange = updateState,
        label = { Text(text = textLabel)},
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ValidatingPasswordTextField( textLabel:String, updateState:(String) -> Unit , textValue:String){
    OutlinedTextField(
        value = textValue,
        onValueChange = updateState,
        label = { Text(text = textLabel)},
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun ForgotPasswordText(){
    Text(text = "Forgot Your Password", textAlign = TextAlign.End)
}




@Preview(showBackground = true)
@Composable
fun KiiptrakLoginPreview() {
    KiiptrakTheme {
        LoginActivityControls(loginMessage = "Kiiptrak", subText = "Login To Your Account")
    }
}