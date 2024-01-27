package com.example.someoldjokes.presentation.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.someoldjokes.presentation.network.ApiService
import com.example.someoldjokes.presentation.network.Article
import com.example.someoldjokes.presentation.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val apiService: ApiService = RetrofitClient.retrofit.create(ApiService::class.java)
    val isLoading = MutableStateFlow(false)
    val isStatus = MutableStateFlow(false)
    private var _listNews = MutableStateFlow<List<Article>>(emptyList())
    val listNews = _listNews.asStateFlow()


     fun getList() {
        isLoading.value=true
        viewModelScope.launch {
            try {
                val response = apiService.getSomeData()
                if (response.isSuccessful) {
                    isLoading.value=false
                    Log.d("TAGS", "getList: "+ response.body()!!.articles)
                    _listNews.value = response.body()!!.articles
                } else {
                    isLoading.value=false
                    _listNews.value = emptyList()
                }
            } catch (e: Exception) {
                _listNews.value = emptyList()
            }
        }
    }

}