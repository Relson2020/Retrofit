package com.example.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    fun getData() : Call<List<MyDataItem>>

    @POST("posts")
    fun postData(@Body post : MyDataItem) : Call<MyDataItem>

    @PUT("posts/{id}")
    fun putData(@Path("id") id : Int ,@Body put : MyDataItem) : Call<MyDataItem>

    @PATCH("posts/{id}")
    fun patchData(@Path("id") id : Int ,@Body put : MyDataItem) : Call<MyDataItem>

    @DELETE("posts/{id}")
    fun deleteData(@Path("id") id : Int):Call<Unit>
}