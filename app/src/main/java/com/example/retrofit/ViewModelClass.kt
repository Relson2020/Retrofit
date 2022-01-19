package com.example.retrofit

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelClass : ViewModel() {

    val getLiveData : MutableLiveData<List<MyDataItem>> = MutableLiveData()
    val postLiveData : MutableLiveData<List<MyDataItem>> = MutableLiveData()

    fun getData(){
//        viewModelScope.launch {
//            getLiveData.postValue(RetrofitBuilder.retrofitInstance.getData())
//        }
    }
    fun postData(post : MyDataItem){
//        viewModelScope.launch {
//            postLiveData.postValue(RetrofitBuilder.retrofitInstance.postData(post))
//        }
    }
}