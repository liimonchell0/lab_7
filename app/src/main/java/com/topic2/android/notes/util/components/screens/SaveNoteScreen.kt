package com.topic2.android.notes.util.components.screens

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.topic2.android.notes.domain.model.ColorModel
import com.topic2.android.notes.util.components.NoteColor
import com.topic2.android.notes.util.fromHex
import com.topic2.android.notes.viewmodel.MainViewModel


@Composable
fun SaveNoteScreen(viewModel: MainViewModel){

}
@Composable
private fun ColorPicket(
    colors: List<ColorModel>,
    onColorSelect: (ColorModel) -> Unit
){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Color picker",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)

        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ){
            items(
                colors.size
            ){
                itemIdex ->
                val color = colors[itemIdex]
                ColorItem(
                    color = color,
                    onColorSelect = onColorSelect
                )
            }
        }
    }

}




@Composable
fun ColorItem(
    color: ColorModel,
    onColorSelect:(ColorModel) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onColorSelect(color)
                }
            )
    ){
        NoteColor(
            modifier = Modifier
                .padding(10.dp),
            color = Color.fromHex(color.hex),
            size = 80.dp,
            border = 2.dp
        )
         Text(
             text = color.name,
             fontSize = 22.sp,
             modifier = Modifier
                 .padding(horizontal = 16.dp)
                 .align(Alignment.CenterVertically)
         )
    }

}

@Preview
@Composable
fun ColorItemView(){
    ColorItem(ColorModel.DEFAULT){}
}
@Preview
@Composable
fun  ColorPickerPreview(){
    ColorPicket(colors = listOf(
        ColorModel.DEFAULT,
        ColorModel.DEFAULT,
        ColorModel.DEFAULT
    )
    ){}
}