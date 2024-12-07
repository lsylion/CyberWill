package com.example.myapplication3.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answers: List<Answer>)

    @Query("SELECT * FROM answers WHERE zodiac_group = :zodiacGroup AND mbti_Group = :mbtiGroup")
    suspend fun getAnswerByZodiacAndMbti(zodiacGroup: String, mbtiGroup: String): List<Answer>?

    @Query("SELECT * FROM answers WHERE zodiac_group = :zodiacGroup AND mbti_group = :mbtiGroup ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomAnswerByGroups(zodiacGroup: String, mbtiGroup: String): Answer?

    // 插入一条记录
    @Insert(onConflict = OnConflictStrategy.REPLACE) // 确保在冲突时替换
    fun insert(answer: Answer)

    // 查询所有记录，返回 LiveData 类型以便观察
    @Query("SELECT * FROM answers ORDER BY id DESC")
    fun getAllAnswers(): LiveData<List<Answer>>

    // 清空所有记录
    @Query("DELETE FROM answers")
    fun clearAllAnswers()

    @Query("SELECT * FROM answers WHERE zodiac_group = :zodiacGroup AND mbti_group = :mbtiGroup")
    suspend fun getAnswersByGroups(zodiacGroup: String, mbtiGroup: String): List<Answer>

    // 添加一个测试方法来检查数据是否存在
    @Query("SELECT COUNT(*) FROM answers")
    suspend fun getAnswerCount(): Int

    // 添加一个调试方法
    @Query("SELECT * FROM answers")
    suspend fun getAllAnswersForDebug(): List<Answer>


}
