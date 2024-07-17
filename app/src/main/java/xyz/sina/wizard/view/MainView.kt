package xyz.sina.wizard.view


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import xyz.sina.wizard.R
import xyz.sina.wizard.model.DI.Injection
import xyz.sina.wizard.utils.Txt
import xyz.sina.wizard.viewModel.WiseViewModel



val cocomatFont = FontFamily(
    Font(R.font.cocomat)
)

@Composable
fun WiseView(viewModel: WiseViewModel = viewModel(factory = WiseViewModelFactory() )) {

    val wise by viewModel.wise.collectAsState()

    LaunchedEffect (Unit) {
        viewModel.fetchWise()
    }


    var visible by remember { mutableStateOf(false) }
    var secondVisible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    LaunchedEffect(visible) {
        if (visible) {
            delay(2000L)
            secondVisible = true
        } else {
            secondVisible = false
        }
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!visible) {
            Text(

                text = Txt.appName,
                style = TextStyle(fontFamily = cocomatFont ,fontSize = 60.sp, fontWeight = FontWeight.SemiBold, color = Color(3, 4, 94)),
                modifier = Modifier.clickable { visible = !visible }

            )
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(expandFrom = Alignment.Top) +
                    fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically {
                with(density) { 40.dp.roundToPx() }
            } + shrinkVertically() +
                    fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(3, 4, 94))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    AnimatedVisibility(
                        visible = secondVisible,
                        enter = slideInVertically {
                            with(density) { -40.dp.roundToPx() }
                        } + expandVertically(expandFrom = Alignment.Top) +
                                fadeIn(initialAlpha = 0.3f)

                    ) {
                        Text(
                            text = Txt.appName,
                            style = TextStyle(fontFamily = cocomatFont ,fontSize = 60.sp, fontWeight = FontWeight.SemiBold, color = Color(144, 224, 239))
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(Txt.info, style = TextStyle(fontFamily = cocomatFont ,fontSize = 30.sp, fontWeight = FontWeight.SemiBold, color = Color(202, 240, 248)))
                    val text = wise?.let {
                        listOf(
                            it.content,
                            )
                    }?: run{
                        listOf(
                            "Wizard is tired :("
                        )
                    }
                    TypeWriter(text)

                }
            }
        }
    }
}


@Composable
fun TypeWriter(text : List<String>) {

    var textIndex by remember { mutableIntStateOf(0) }
    var textToDisplay by remember { mutableStateOf("") }

    LaunchedEffect (key1 = text){
        delay(2400)
        while(textIndex < text.size){

            text[textIndex].forEachIndexed { characterIndex, _ ->

                textToDisplay = text[textIndex].substring(startIndex = 0, endIndex = characterIndex + 1)
                delay(200)

            }
            textIndex ++

        }

    }
    Text(modifier  = Modifier.padding(16.dp),text = textToDisplay, style = TextStyle(textAlign = TextAlign.Center ,fontFamily = cocomatFont ,fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color(0, 180, 216)))

}


@Suppress("UNCHECKED_CAST")
class WiseViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WiseViewModel::class.java)) {
            return Injection.provideWiseViewModel() as T
        }
        throw IllegalArgumentException("UNKNOWN VIEWMODEL")
    }

}