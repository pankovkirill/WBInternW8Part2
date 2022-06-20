package com.example.wbinternw8part2.model.repository

interface Repository<T> {
    suspend fun getData(): T
}