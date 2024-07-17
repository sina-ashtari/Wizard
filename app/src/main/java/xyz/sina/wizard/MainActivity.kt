package xyz.sina.wizard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import xyz.sina.wizard.ui.theme.WizardTheme
import xyz.sina.wizard.view.WiseView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WizardTheme {
                WiseView()
            }
        }
    }
}




