package com.example.myapplication3.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class FirstScreenComposable {
}

@Composable
fun CustomListItem(
    text: String,
    rightText: String,
    onClick: () -> Unit,
    rightIcon: @Composable (() -> Unit)? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween, // 两端对齐
        verticalAlignment = Alignment.CenterVertically// 垂直对齐到中心
    ) {
        Text(text = text)
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = rightText)
            Spacer(modifier = Modifier.width(5.dp))
            rightIcon?.invoke() // Display the right icon if provided
        }
    }
}

@Composable
fun InputTextDialog1(
    initialText: String = "",
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var inputText by remember { mutableStateOf(initialText) } // 用于保存输入的文本

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("请输入您的消费金额") },
        text = {
            Column {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it }, // 更新输入文本
                    label = { Text("请输入内容") } // 输入框的标签
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(inputText) // 确认时传递输入的文本
                onDismiss() // 关闭对话框
            }) {
                Text("确定")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}


@Composable
fun InputTextDialog2(
    initialText: String = "",
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var inputText by remember { mutableStateOf(initialText) } // 用于保存输入的文本

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("请输入交易产生时间") },
        text = {
            Column {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it }, // 更新输入文本
                    label = { Text("日期格式：20011121") } // 输入框的标签
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(inputText) // 确认时传递输入的文本
                onDismiss() // 关闭对话框
            }) {
                Text("确定")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

@Composable
fun InputTextDialog3(
    initialText: String = "",
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var inputText by remember { mutableStateOf(initialText) } // 用于保存输入的文本

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("请输入备注") },
        text = {
            Column {
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it }, // 更新输入文本
                    label = { Text(" ") } // 输入框的标签
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(inputText) // 确认时传递输入的文本
                onDismiss() // 关闭对话框
            }) {
                Text("确定")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

//创建Dashed Divider方法 用于分隔符的频繁调用
@Composable
fun DashedDivider() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        val dashWidth = 10f
        val dashGap = 5f
        var x = 0f
        while (x < size.width) {
            drawLine(
                color = Color.Gray,
                start = Offset(x, 0f),
                end = Offset(x + dashWidth, 0f),
                strokeWidth = 1f
            )
            x += dashWidth + dashGap
        }
    }
}