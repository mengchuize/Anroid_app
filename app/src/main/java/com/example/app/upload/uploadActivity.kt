package com.example.app.upload

import android.app.Activity
import android.util.Log
import com.example.app.models.activity
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class uploadActivity {
    private var mRetrofit: Retrofit? = null
    private var activitys:activity? = null
    private fun initActivity(activitys:activity) {
        this.activitys=activitys

    }

    interface upload {
        @POST("/activity")
        fun uploadjosn(@Body t:activity?):  retrofit2.Call<activity?>?
    }

    fun initUploadBase(baseurl: String?,activitys:activity) {
        initActivity(activitys)
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getupload = mRetrofit?.create(upload::class.java)
        //对 发送请求 进行封装
        val call:  retrofit2.Call<activity?>? =
            getupload?.uploadjosn(activitys)
            System.out.println("ttttt:"+activitys)
                //发送网络请求(异步)
        call?.enqueue(object : Callback<activity?> {
            //请求成功时回调
            override fun onResponse(
                call: retrofit2.Call<activity?>,
                response: Response<activity?>
            ) {
                Log.i("s0", "上传成功")
            }

            //请求失败时回调
            override fun onFailure(
                call: retrofit2.Call<activity?>?,
                throwable: Throwable?
            ) {
                println(throwable!!.message)
            }
        })
    }
}