package com.example.presentation.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.models.CoachData
import com.example.domain.models.LessonData

@Composable
fun LessonsMainScreen(navController: NavHostController) {
    val viewModel: LessonScreenViewModel = hiltViewModel()
    val lessonsList by viewModel.lessonsList.collectAsState()

    LessonsMainContent(lessonsList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonsMainContent(lessonsList: List<LessonData>) {
    val grouped = lessonsList.groupBy { it.date }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().height(50.dp).background(Color.LightGray),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Рассписание", fontSize = 20.sp)
        }
        LazyColumn() {
            grouped.forEach { data, lesson ->
                stickyHeader {
                    Row(modifier = Modifier.fillMaxWidth().background(Color.White), horizontalArrangement = Arrangement.Start) {
                        Text(
                            text = data,
                            modifier = Modifier
                                .padding(16.dp),
                        )
                    }
                }

                items(
                    lesson.sortedBy {
                        it.startTime
                    },
                ) {
                    LessonListItem(it)
                }
            }
        }
    }
}

@Composable
fun LessonListItem(lessonDate: LessonData) {
    Card(modifier = Modifier.padding(5.dp).fillMaxWidth().height(90.dp), border = BorderStroke(1.dp, Color.LightGray), shape = RoundedCornerShape(5.dp)) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.background(getColor(lessonDate.color)).height(100.dp).width(10.dp)) {
            }
            Column(modifier = Modifier.background(Color.White).padding(start = 5.dp).fillMaxSize()) {
                Row(modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                    Text(text = lessonDate.startTime)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = lessonDate.name, fontWeight = FontWeight.Bold)
                }
                Row(modifier = Modifier.padding(10.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = lessonDate.endTime)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(Icons.Default.Person, contentDescription = "person")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = lessonDate.coach?.name.toString(), fontSize = 11.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(Icons.Default.LocationOn, contentDescription = "location")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = lessonDate.place, fontSize = 9.sp, maxLines = 1)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LessonListItemPreview() {
    val lessonDate = LessonData(name = "ABS/BODY STRETCH", place = "Большой зал ОлимпияSPORT", coach = CoachData(id = "employee_id_100292", name = "Архипова Мария"), color = "#55FF7F", startTime = "11:15", endTime = "12:10", date = "2023-04-28")

    LessonListItem(lessonDate)
}

fun getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}
