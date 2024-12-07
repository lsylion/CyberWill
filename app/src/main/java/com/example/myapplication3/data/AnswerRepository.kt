package com.example.myapplication3.data

class AnswerRepository(private val answerDao: AnswerDao) {
    suspend fun getRandomAnswer(zodiacGroup: String, mbtiGroup: String): Answer? {
        return answerDao.getRandomAnswerByGroups(zodiacGroup, mbtiGroup)
    }

    suspend fun getAllAnswersByGroups(zodiacGroup: String, mbtiGroup: String): List<Answer> {
        return answerDao.getAnswersByGroups(zodiacGroup, mbtiGroup)
    }

    suspend fun getAnswerCount(): Int {
        return answerDao.getAnswerCount()
    }

    suspend fun getAllAnswersForDebug(): List<Answer> {
        return answerDao.getAllAnswersForDebug()
    }

    suspend fun insertAnswer(answer: Answer) {
        answerDao.insert(answer)
    }

}
