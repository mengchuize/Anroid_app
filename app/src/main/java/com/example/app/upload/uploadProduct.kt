package com.example.app.upload

import android.app.Activity
import android.util.Log
import com.example.app.models.activity
import com.example.app.models.commodity
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class uploadProduct {
    private var mRetrofit: Retrofit? = null
    private var commoditys:commodity? = null
    private fun initcommodity(commoditys:commodity?) {
        this.commoditys=commoditys

    }

    interface upload {
        @POST("/transaction")
        fun uploadjosn(@Body t:commodity?):  retrofit2.Call<commodity?>?
    }

    fun initUploadBase(baseurl: String?,mcommodity:commodity) {
        initcommodity(commoditys)
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getupload = mRetrofit?.create(upload::class.java)
        //对 发送请求 进行封装
        val call:  retrofit2.Call<commodity?>? =
            getupload?.uploadjosn(mcommodity)
            System.out.println("ttttt:"+mcommodity.name)
                //发送网络请求(异步)
        call?.enqueue(object : Callback<commodity?> {
            //请求成功时回调
            override fun onResponse(
                call: retrofit2.Call<commodity?>,
                response: Response<commodity?>
            ) {
                Log.i("s0", "上传成功")
            }

            //请求失败时回调
            override fun onFailure(
                call: retrofit2.Call<commodity?>?,
                throwable: Throwable?
            ) {
                println(throwable!!.message)
            }
        })
    }
}