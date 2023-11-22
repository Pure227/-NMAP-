package com.example.myapplab2

import android.media.tv.PesRequest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplab2.ui.theme.MyAppLab2Theme

data class Person(val name:String,
                  val studentID:String,
                  val imageID:Int)

class MainActivity : ComponentActivity() {
    var persons: List<Person> = listOf(
        Person("นายจักรพรรดิ์ อนุไพร","643450065-4",R.drawable.jakapat),
        Person("นายอรัญ ศรีสวัสดิ์","643450095-5",R.drawable.arun),
        Person("นายธนบดี สวัสดี","643450325-4",R.drawable.team),
        Person("นายวิญญู พรมภิภักดิ์","643450084-0",R.drawable.winyu),
        Person("นายอภิทุน ดวงจันทร์คล้อย","643450092-1",R.drawable.pond),
        Person("นายเกรียงศักดิ์ หมู่เมืองสอง","643450322-0",R.drawable.ll),
        Person("นายรัตพงษ์ ปานเจริญ","643450650-3",R.drawable.tey),
        Person("professor code","404",R.drawable.code)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppLab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   LazyColumn{
                       items(persons){
                           data -> Personlist(data)
                       }
                   }
                }
            }
        }
    }
}

@Composable
fun Personlist(data:Person){
    Row() {
        Image(
            painter = painterResource(id = data.imageID),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
        )
        Column(modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center) {
            Text(data.name)
            Text(data.studentID)
        }
    }
}




