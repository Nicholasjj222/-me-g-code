package com.vibe.repository

import com.vibe.model.Session
import java.util.concurrent.ConcurrentHashMap

class SessionRepository {

    private val sessions = ConcurrentHashMap<Int, Session>()
    private var nextId = 1

    fun save(session: Session): Session {
        val newSession = session.copy(id = nextId++)
        sessions[newSession.id] = newSession
        return newSession
    }

    fun findAll(): List<Session> = sessions.values.toList()

    fun findByUser(userId: Int): List<Session> =
        sessions.values.filter { it.userId == userId }

    fun delete(sessionId: Int): Boolean = sessions.remove(sessionId) != null
}