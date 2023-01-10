package ir.saeedbahari.mypetproject.ui.listScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserItemRow(
    title: String,
    userId: String = "",
    fontSize: TextUnit = 20.sp,

) {
    var backgroundColor by remember {
        mutableStateOf(Color.White)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(backgroundColor)
            .clickable {
                backgroundColor = if (backgroundColor == Color.White)
                    Color.Red
                 else
                    Color.White
            }
            ,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title, fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            Text(
                text = userId,
                fontSize = fontSize,
                modifier = Modifier.padding(14.dp, 0.dp, 0.dp, 0.dp)
            )
        }

        Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun NameItemPreview() {
    UserItemRow(title = "Saeed")
}