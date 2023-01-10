package ir.saeedbahari.mypetproject.ui.listScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.saeedbahari.mypetproject.model.UserDto
import ir.saeedbahari.mypetproject.ui.listScreen.component.UserItemRow

val userDto = listOf(
    UserDto(title = "Saeed", id = 0),
    UserDto(title = "Vahid", id = 1),
    UserDto(title = "Mahdi", id = 2),
    UserDto(title = "AmirHosein", id = 3),
    UserDto(title = "Sahar", id = 4),
)

@Composable
fun ListScreen(
    usersList: List<UserDto> = userDto
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "UserList",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }
        items(
            items = usersList,
            key = {user->
                user.id
            }
        ) {
            UserItemRow(title = it.title, fontSize = 20.sp, userId = it.id.toString())
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun ListScreenPreview(

) {
    ListScreen()
}