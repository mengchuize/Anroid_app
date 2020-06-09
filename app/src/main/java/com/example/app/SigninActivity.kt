package com.example.app

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.app.httprequests.httprequest
import com.example.app.models.activity
import com.example.app.upload.uploadActivity
import org.json.JSONArray
import retrofit2.Call

import java.util.*
import kotlin.collections.ArrayList


class SigninActivity : AppCompatActivity(){

    var json_signin=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        val back: ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        Thread(networkTask).start();
        while(json_signin == ""){
            var i=1
        }
        val json_object= JSONArray(json_signin)
        var days: MutableList<Int> = ArrayList<Int>()
        var imageViews: MutableList<ImageView> = ArrayList<ImageView>()

        for(i in 0..6){
            days.add(0)
        }

        val yn1=findViewById<ImageView>(R.id.yesorno1)
        val yn2=findViewById<ImageView>(R.id.yesorno2)
        val yn3=findViewById<ImageView>(R.id.yesorno3)
        val yn4=findViewById<ImageView>(R.id.yesorno4)
        val yn5=findViewById<ImageView>(R.id.yesorno5)
        val yn6=findViewById<ImageView>(R.id.yesorno6)
        val yn7=findViewById<ImageView>(R.id.yesorno7)
        imageViews.add(yn1)
        imageViews.add(yn2)
        imageViews.add(yn3)
        imageViews.add(yn4)
        imageViews.add(yn5)
        imageViews.add(yn6)
        imageViews.add(yn7)
        var m=-1
        for (i in 0..json_object.length()-1){
            if (json_object.getJSONObject(i).getString("activity_name")=="signin"){
                m=i
            }
        }
        System.out.println("SIGNINNUM:"+m)
        System.out.println("days.size:"+days.size)
        System.out.println("split:"+json_object.getJSONObject(m).getString("activity_des").split(",").size)
        for(i in 0..json_object.getJSONObject(m).getString("activity_des").split(",").size-1){

            days[json_object.getJSONObject(m).getString("activity_des").split(",").get(i).toInt()-1]=1
        }
        for (i in 0..getWeek()-1) {
            if (days[i]==1){
                imageViews[i].setImageResource(R.drawable.yes)
            }else{
                imageViews[i].setImageResource(R.drawable.no)
            }

        }
        for (i in getWeek()..6){
            imageViews[i].setImageResource(R.drawable.wait)
        }

        val signin=findViewById<ConstraintLayout>(R.id.constraintLayout3)
        signin.setOnClickListener(View.OnClickListener {
            val up:uploadActivity=uploadActivity()
            var signinactivity: activity= activity("signin","1",json_object.getJSONObject(m).getString("activity_des")+","+getWeek())
            up.initUploadBase("http://49.234.76.144:5566",signinactivity)
        })

    }

    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_signin=hr.httprequestsActivity()
    }
    private fun getWeek(): Int {
        var week = 0
        val today = Date()
        val c = Calendar.getInstance()
        c.time = today
        val weekday = c[Calendar.DAY_OF_WEEK]
        if (weekday == 1) {
            week = 6
        } else if (weekday == 2) {
            week = 0
        } else if (weekday == 3) {
            week = 1
        } else if (weekday == 4) {
            week = 2
        } else if (weekday == 5) {
            week = 3
        } else if (weekday == 6) {
            week = 4
        } else if (weekday == 7) {
            week = 5
        }
        return week
    }


}
