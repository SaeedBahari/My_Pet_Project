package ir.saeedbahari.mypetproject.ui.main


import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.saeedbahari.mypetproject.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(4.dp)
        ) {
            var message by rememberSaveable {
                mutableStateOf("What's your name?")
            } //"enter your name?"
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = context.resources.getString(R.string.main_screen_title))
//            OutlinedButton(onClick = {
//                Toast.makeText(context, "Show Toast", Toast.LENGTH_SHORT).show()
//            }, modifier = Modifier.fillMaxWidth()) {
//                Text(text = "Open Another Screen")
//            }
            Button(onClick = {
                message = "Saeed Bahari"
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Add Your Name")
            }
            Text(text = message)

            var isVisible by rememberSaveable {
                mutableStateOf(true)
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                isVisible = !isVisible
            }, modifier = Modifier.fillMaxWidth()) {
                if (isVisible)
                    Text(text = "Hide TextView")
                else
                    Text(text = "Show TextView")
            }
            //            if (isVisible)
//                Text(text = "Target TextView")
            // انیمیشن
            AnimatedVisibility(
                visible = isVisible,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                Text(text = "Target TextView")
            }



        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

