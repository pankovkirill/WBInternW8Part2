package com.example.wbinternw8part2.model.repository

import com.example.wbinternw8part2.model.data.DataModel
import com.example.wbinternw8part2.model.datasource.DataSource
import com.example.wbinternw8part2.model.datasource.RetrofitImpl

class RepositoryImpl(
    private val dataSource: DataSource<List<DataModel>> = RetrofitImpl()
) : Repository<List<DataModel>> {
    override suspend fun getData(): List<DataModel> {
        return dataSource.getData()
    }
}