package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapter.commodityAdapter
import com.example.app.adapter.detialAdapter
import com.example.app.httprequests.httprequest
import com.example.app.models.commodity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.app.models.detial
import org.json.JSONArray

class DetialActivity : AppCompatActivity() {

    private val detialList: MutableList<detial> = ArrayList<detial>()
    var json_detial=""
    var json_activity=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detial)

        val back: ImageButton = findViewById(R.id.back_button2)
        back.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        initDetial()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_detial)
        recyclerView.removeAllViews()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = detialAdapter(detialList)

        adapter.setOnItemClickListener(object : detialAdapter.OnItemClickListener {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> {
//                        val intent = Intent(this, MainActivity::classs.java)
//                        startActivity(intent)
                    }
                    1 -> {
//                        val intent1 = Intent(this, python2Activity::classs.java)
//                        startActivity(intent1)
                    }
                    3 -> {
//                        val intent = Intent(this, MainActivity::classs.java)
//                        startActivity(intent)
                    }
                    4 -> {
//                        val intent1 = Intent(this, python2Activity::classs.java)
//                        startActivity(intent1)
                    }
                }
            }
        })
        recyclerView.adapter = adapter
    }
    fun initDetial(){
        for (i in detialList.indices.reversed()) {
            detialList.removeAt(i)
        }

        Thread(networkTask).start();
        while(json_detial == ""){
            var i=1
        }
        val json_object1= JSONArray(json_detial)
        val json_object2= JSONArray(json_activity)
        for (i in 0..json_object1.length()-1) {
            val a =
                detial(json_object1.getJSONObject(i).getString("p_name"),
                    json_object1.getJSONObject(i).getString("tr_time"),
                    json_object1.getJSONObject(i).getInt("p_price")*-1)
            detialList.add(a)

        }
        for (i in 0..json_object2.length()-1) {
            val a =
                detial(json_object2.getJSONObject(i).getString("activity_name"),
                    json_object2.getJSONObject(i).getString("activity_begintime"),
                    json_object2.getJSONObject(i).getInt("score"))
            detialList.add(a)

        }

    }

    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_activity=hr.httprequestsActivity()
        json_detial=hr.httprequestsDetail()
    }
}
