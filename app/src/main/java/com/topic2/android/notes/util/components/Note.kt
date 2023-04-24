package com.topic2.android.notes.util.components


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.topic2.android.notes.theme.rwGreen

@Composable
fun Note() {
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    Row(
        modifier = Modifier
            .padding(8.dp)
            .shadow(1.dp, backgroundShape)
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .background(Color.White, backgroundShape)
    ) {

        NoteColor(
            color = rwGreen,
            size = 40.dp,
            padding = 4.dp,
            border = 1.dp
        )
        Column(modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterVertically)
        ) {
            Text(text = "Заголовок", maxLines = 1)
            Text(text = "Содержание", maxLines = 1)
        }

        Checkbox(
            checked = false, onCheckedChange = {},
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        )

    }
}
@Preview
@Composable
fun NotePreview(){
    Note()
}