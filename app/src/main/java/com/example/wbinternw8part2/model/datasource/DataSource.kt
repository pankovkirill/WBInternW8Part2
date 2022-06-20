package com.example.wbinternw8part2.model.datasource

interface DataSource<T> {
    suspend fun getData(): T
}