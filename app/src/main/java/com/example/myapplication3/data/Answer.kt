package com.example.myapplication3.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 创建一个实体类，表示每条回答
@Entity(tableName = "answers")
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "content") val content: String,

    // ROOM 不支持动态表名，通过字段标记分类
    @ColumnInfo(name = "zodiac_group") val zodiacGroup: String,  // 星座分组
    @ColumnInfo(name = "mbti_group") val mbtiGroup: String  // MBTI 分组
)

