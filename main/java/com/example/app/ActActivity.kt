package com.example.app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.activity.ActivityActivity
import com.example.app.activity.ProductActivity
import com.example.app.adapter.activityAdapter
import com.example.app.adapter.commodityAdapter
import com.example.app.httprequests.httprequest
import com.example.app.models.activity
import com.example.app.models.order
import org.json.JSONArray
import java.util.ArrayList

class ActActivity : AppCompatActivity() {
    private val activityList: MutableList<activity> = ArrayList<activity>()
    var json_activity=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act)

        val back: ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(View.OnClickListener {
//            this.finish()
            val intent = Intent(this@ActActivity, MainActivity::class.java)
            startActivity(intent)
        })

        initActivity()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_activity)
        recyclerView.removeAllViews()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = activityAdapter(activityList)

        adapter.setOnItemClickListener(object : activityAdapter.OnItemClickListener {
            override fun onClick(position: Int) {
                val json_object= JSONArray(json_activity)
                val sp = getSharedPreferences("config", 0)
                val editor: SharedPreferences.Editor = sp.edit()
                when (position) {
                    0 -> {

                        editor.putString("activityName", json_object.getJSONObject(0).getString("activity_name"))
                        editor.putString("activityDescription", json_object.getJSONObject(0).getString("activity_des"))
                        editor.putString("activityPrice", json_object.getJSONObject(0).getString("score"))
                        editor.commit()
                        val intent = Intent(this@ActActivity, ActivityActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {

                        editor.putString("activityName", json_object.getJSONObject(1).getString("activity_name"))
                        editor.putString("activityDescription", json_object.getJSONObject(1).getString("activity_des"))
                        editor.putString("activityPrice", json_object.getJSONObject(1).getString("score"))
                        editor.commit()
                        val intent = Intent(this@ActActivity, ActivityActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {

                        editor.putString("activityName", json_object.getJSONObject(2).getString("activity_name"))
                        editor.putString("activityDescription", json_object.getJSONObject(2).getString("activity_des"))
                        editor.putString("activityPrice", json_object.getJSONObject(2).getString("score"))
                        editor.commit()
                        val intent = Intent(this@ActActivity, ActivityActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {

                        editor.putString("productName", json_object.getJSONObject(3).getString("activity_name"))
                        editor.putString("productDescription", json_object.getJSONObject(3).getString("activity_des"))
                        editor.putString("productPrice", json_object.getJSONObject(3).getString("score"))
                        editor.commit()
                        val intent = Intent(this@ActActivity, ActivityActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
        recyclerView.adapter = adapter
    }
    fun initActivity(){
        for (i in activityList.indices.reversed()) {
            activityList.removeAt(i)
        }
        Thread(networkTask).start();
        while(json_activity == ""){
            var i=1
        }
        val json_object= JSONArray(json_activity)
        for (i in 0..json_object.length()-1) {
            val a =
                activity(json_object.getJSONObject(i).getString("activity_name"),
                    json_object.getJSONObject(i).getString("score"),
                    json_object.getJSONObject(i).getString("activity_des"))
            activityList.add(a)

        }
    }
    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_activity=hr.httprequestsActivity()
    }
}
