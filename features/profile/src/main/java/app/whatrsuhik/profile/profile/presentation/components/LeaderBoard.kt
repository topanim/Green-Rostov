package app.whatrsuhik.profile.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.whatrsuhik.ui.R
import app.whatrsuhik.ui.components.spacer.Space
import app.whatrsuhik.ui.components.spacer.VerticalSpace
import app.whatrsuhik.ui.components.styled_box.StyledBox
import app.whatrsuhik.ui.theme.SHUITheme
import app.whatrsuhik.ui.theme.SHUITheme.spacing

@Composable
fun LeaderBoard() {
    val leaderLick = listOf(
        LeaderMock(
            "Паша",
            "Брускевич",
            R.drawable.frame1
        ),
        LeaderMock(
            "Паша",
            "Брускевич",
            R.drawable.frame1
        ),
        LeaderMock(
            "Паша",
            "Брускевич",
            R.drawable.frame1
        )
    )
    Column {
        Text(
            "Лидеры недели",
            style = SHUITheme.typography.list,
            color = SHUITheme.palettes.foreground
        )
        Space(spacing.lg)

        StyledBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 6.dp)
        ) {
            Column {
                leaderLick.forEach {
                    UserItem(it.image, it.name, it.surname)
                    VerticalSpace(spacing.xs)
                }
            }
        }
    }


}

@Composable
fun UserItem(image: Int, name: String, surname: String) = StyledBox(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(image), "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(26.dp)
        )
        Space(spacing.sm)
        Text(
            "$name $surname",
            style = SHUITheme.typography.subleSemibold
        )
    }
}