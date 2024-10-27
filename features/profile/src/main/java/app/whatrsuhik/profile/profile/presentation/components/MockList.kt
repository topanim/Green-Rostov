package app.whatrsuhik.profile.profile.presentation.components

import androidx.annotation.DrawableRes
import app.whatrsuhik.ui.R

data class LeaderMock(
    val name: String,
    val surname: String,
    @DrawableRes
    val image: Int
)

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