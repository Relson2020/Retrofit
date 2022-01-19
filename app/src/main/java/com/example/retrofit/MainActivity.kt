package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var textViewData = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.getButton.setOnClickListener {
            getMyData()
        }
        binding.postButton.setOnClickListener {
            postMyData()
        }
        binding.putButton.setOnClickListener {
            putData()
        }
        binding.patchButton.setOnClickListener {
            patchData()
        }
        binding.deleteButton.setOnClickListener {
            deleteData()
        }

    }


    private fun getMyData() {
        val getData = RetrofitBuilder.retrofitInstance.getData()
        getData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    for (myData in responseBody) {
                        val data =
                            "Id : ${myData.id} \nTitle : ${myData.title} \nBody : ${myData.body} \n\n"
                        textViewData += data
                    }
                    textViewDisplay(textViewData)
                }
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
            }

        })

    }

    private fun postMyData() {
        val data = MyDataItem("hey there its body ", 101, "its a title ", 11)
        val postResult = RetrofitBuilder.retrofitInstance.postData(data)
        postResult.enqueue(object : Callback<MyDataItem> {
            override fun onResponse(call: Call<MyDataItem>, response: Response<MyDataItem>) {
                val responseData = response.body()
                val tempData =
                    "code : ${response.code()} \nId : ${responseData?.id} \nTitle : " +
                            "${responseData?.title} \nBody : ${responseData?.body}"
               textViewDisplay(tempData)
            }

            override fun onFailure(call: Call<MyDataItem>, t: Throwable) {
            }
        })
    }

    private fun putData(){
        val data = MyDataItem("hey its put data ",33,"",4)
        val putData = RetrofitBuilder.retrofitInstance.putData(33,data)
        putData.enqueue(object : Callback<MyDataItem?> {
            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                val responseData = response.body()
                val tempData =
                    "code : ${response.code()} \nId : ${responseData?.id} \nTitle : " +
                            "${responseData?.title} \nBody : ${responseData?.body}"
                textViewDisplay(tempData)
            }
            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {

            }
        })
    }

    private fun patchData(){
        val data = MyDataItem("hey its patch data ",33,"",4)
        val patchData = RetrofitBuilder.retrofitInstance.patchData(33,data)
        patchData.enqueue(object : Callback<MyDataItem?> {
            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                val responseData = response.body()
                val tempData =
                    "code : ${response.code()} \nId : ${responseData?.id} \nTitle : " +
                            "${responseData?.title} \nBody : ${responseData?.body}"
                textViewDisplay(tempData)
            }
            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {
            }
        })
    }

    private fun deleteData(){
        val deleteData = RetrofitBuilder.retrofitInstance.deleteData(33)
        deleteData.enqueue(object : Callback<Unit?> {
            override fun onResponse(call: Call<Unit?>, response: Response<Unit?>) {
                 textViewDisplay("${response.code()}")
            }

            override fun onFailure(call: Call<Unit?>, t: Throwable) {
            }
        })

    }

    private fun textViewDisplay(data : String){
        binding.textView.text = data
    }
}