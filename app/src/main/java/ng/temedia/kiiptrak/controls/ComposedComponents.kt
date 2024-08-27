package ng.temedia.kiiptrak.controls

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel


class TextViewModel: ViewModel(){
    var text by mutableStateOf("")
        private set
    fun updateText(passedText:String){
        text = passedText
    }
}


@Composable
fun LoginButton(text:String, onclick:()-> Unit){
    Button(
        onClick = { onclick() },
        shape = RoundedCornerShape(5.dp),

        colors = ButtonColors(
            containerColor = Color(0xFF60129d),
            contentColor = Color(0xFFDBD4D4),
            disabledContentColor = Color(0xFFDBD4D4),
            disabledContainerColor = Color(0xFFDBD4D4),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun LoginImageButton(textLabel: String, onclick: () -> Unit, @DrawableRes image: Int, imageDescription:String){
    Button(
        onClick = { onclick() },
        shape = RoundedCornerShape(5.dp),
        colors = ButtonColors(
            containerColor = Color(0xFFDBD4D4),
            contentColor = Color(0xFFDBD4D4),
            disabledContentColor = Color(0xFFDBD4D4),
            disabledContainerColor = Color(0xFFDBD4D4),
        ),
        modifier = Modifier
            .fillMaxWidth()


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = imageDescription,
                Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = textLabel, color = Color.Black)
        }

    }
}

@Composable
fun ValidatingInputTextField( textLabel:String, updateState:(String) -> Unit , textValue:String){
    OutlinedTextField(
        value = textValue,
        onValueChange = updateState,
        label = { Text(text = textLabel) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ValidatingPasswordTextField( textLabel:String, updateState:(String) -> Unit , textValue:String){
    OutlinedTextField(
        value = textValue,
        onValueChange = updateState,
        label = { Text(text = textLabel) },
        modifier = Modifier.fillMaxWidth()
    )
}