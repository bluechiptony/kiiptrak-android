package ng.temedia.kiiptrak.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ng.temedia.kiiptrak.activities.ui.theme.KiiptrakTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KiiptrakTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DashboardActivityControls(
                        name = "James",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardActivityControls(name: String, modifier: Modifier = Modifier) {
    Column {
        AppTopBar(name = name, modifier =modifier)
    }
}


@Composable
fun AppTopBar(name:String, modifier: Modifier){
    Text(text = "Hi, $name", modifier)
}


@Preview(showBackground = true)
@Composable
fun DashboardActivityControlsPreview() {
    KiiptrakTheme {
        DashboardActivityControls("James")
    }
}