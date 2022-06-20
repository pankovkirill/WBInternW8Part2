package com.example.wbinternw8part2.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbinternw8part2.app.App
import com.example.wbinternw8part2.model.data.AppState
import com.example.wbinternw8part2.model.data.DataModel
import com.example.wbinternw8part2.model.repository.Repository
import com.example.wbinternw8part2.model.repository.RepositoryImpl
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository<List<DataModel>> = RepositoryImpl()
) : ViewModel() {
    private val sharedPreferences =
        App.ContextHolder.context.getSharedPreferences(PREFS_TAG, Context.MODE_PRIVATE)

    private val _data = MutableLiveData<AppState>()

    val liveDataForViewToObserve: LiveData<AppState> = _data

    fun getData() {
        _data.postValue(AppState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val dataFromSharedPrefs = sharedPreferences.getString(DATA_TAG, null)
                val gson = Gson()
                if (dataFromSharedPrefs != null) {
                    val dataFromPrefs = gson.fromJson(
                        dataFromSharedPrefs,
                        Array<DataModel>::class.java
                    ).asList()

                    _data.postValue(AppState.Success(dataFromPrefs))
                } else {
                    val data = repository.getData()
                    _data.postValue(AppState.Success(data))
                    val editor = sharedPreferences.edit()
                    editor.putString(DATA_TAG, gson.toJson(data)).apply()
                }
            } catch (e: Throwable) {
                _data.postValue(AppState.Error(e))
            }
        }
    }

    companion object {
        private const val PREFS_TAG = "superHero"
        private const val DATA_TAG = "data"
    }
}