package com.example.myapplication3.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication3.data.AppDatabase
// import com.example.myapplication3.ui.viewModel.FirstScreenViewModel
import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import java.sql.Types

import com.example.myapplication3.ui.component.CustomListItem
import com.example.myapplication3.ui.component.DashedDivider
import com.example.myapplication3.ui.component.InputTextDialog1
import com.example.myapplication3.ui.component.InputTextDialog2
import com.example.myapplication3.ui.component.InputTextDialog3
import com.example.myapplication3.ui.viewModel.AnswerViewModel


@Composable
fun FirstScreen(
    navController: NavController,
    viewModel: AnswerViewModel
) {
    val isLoading by viewModel.isLoading.observeAsState(false)
    val error by viewModel.error.observeAsState()
    val answers by viewModel.answers.observeAsState(emptyList())

    // 使用 ViewModel 中的状态替代本地状态
    val selectedZodiac by viewModel.selectedZodiac.observeAsState("Water")
    val selectedMBTI by viewModel.selectedMBTI.observeAsState("INTJ")
    var zodiacSelectionDialog by remember { mutableStateOf(false) }
    var mbtiSelectionDialog by remember { mutableStateOf(false) }

    // 使用 ViewModel 中的状态替代本地状态
    val randomButtonClickCount by viewModel.randomButtonClickCount.observeAsState(0)
    var showWarningDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 标题
        Text(
            text = "选择你的星座和MBTI",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        // 星座选择器
        CustomListItem(
            text = "选择星座",
            rightText = selectedZodiac,
            onClick = { zodiacSelectionDialog = true }
        )
        DashedDivider()

        // MBTI选择器
        CustomListItem(
            text = "选择MBTI",
            rightText = selectedMBTI,
            onClick = { mbtiSelectionDialog = true }
        )
        DashedDivider()

        // 保存按钮
        Button(
            onClick = {
                viewModel.fetchAnswers(selectedZodiac, selectedMBTI)
                navController.navigate("second")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White
                )
            } else {
                Text("点这个获得的是真相")
            }
        }

        // 修改随机答案按钮
        Button(
            onClick = {
                viewModel.incrementRandomButtonClickCount()
                if ((randomButtonClickCount + 1 ) % 3 == 0) {  // +1 是因为 LiveData 更新有延迟
                    showWarningDialog = true
                } else {
                    viewModel.fetchRandomAnswer(selectedZodiac, selectedMBTI)
                    navController.navigate("second")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White
                )
            } else {
                Text("点这个获取的是命运")
            }
        }

        // 显示错误信息
        error?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    // 星座选择对话框
    if (zodiacSelectionDialog) {
        AlertDialog(
            onDismissRequest = { zodiacSelectionDialog = false },
            title = { Text("选择星座") },
            text = {
                Column {
                    val zodiacSigns = listOf("Water", "Fire", "Earth", "Air")
                    LazyColumn {
                        items(zodiacSigns) { zodiac ->
                            Text(
                                text = zodiac,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.setSelectedZodiac(zodiac)  // 使用 ViewModel 更新状态
                                        zodiacSelectionDialog = false
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = { zodiacSelectionDialog = false }) {
                    Text("确认")
                }
            }
        )
    }

    // MBTI选择对话框
    if (mbtiSelectionDialog) {
        AlertDialog(
            onDismissRequest = { mbtiSelectionDialog = false },
            title = { Text("选择MBTI") },
            text = {
                Column {
                    val mbtiTypes = listOf("INTJ", "INTP", "ENTJ", "ENTP", "INFJ", "INFP", "ENFJ", "ENFP",
                        "ISTJ", "ISFJ", "ESTJ", "ESFJ", "ISTP", "ISFP", "ESTP", "ESFP")
                    LazyColumn {
                        items(mbtiTypes) { mbti ->
                            Text(
                                text = mbti,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.setSelectedMBTI(mbti)  // 使用 ViewModel 更新状态
                                        mbtiSelectionDialog = false
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = { mbtiSelectionDialog = false }) {
                    Text("确认")
                }
            }
        )
    }

    // 添加警告对话框
    if (showWarningDialog) {
        AlertDialog(
            onDismissRequest = { showWarningDialog = false },
            title = { Text("提示") },
            text = { Text("不要执着于选择命运") },
            confirmButton = {
                Button(onClick = { showWarningDialog = false }) {
                    Text("确定")
                }
            }
        )
    }
}




