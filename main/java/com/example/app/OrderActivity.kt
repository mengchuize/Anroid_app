package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapter.commodityAdapter
import com.example.app.adapter.orderAdapter
import com.example.app.httprequests.httprequest
import com.example.app.models.commodity
import com.example.app.models.order
import org.json.JSONArray
import java.util.ArrayList

class OrderActivity : AppCompatActivity() {

    private val orderList: MutableList<order> = ArrayList<order>()
    var json_order=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val back: ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        initOrder()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_order)
        recyclerView.removeAllViews()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = orderAdapter(orderList)

        adapter.setOnItemClickListener(object : orderAdapter.OnItemClickListener {
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
    fun initOrder(){
        for (i in orderList.indices.reversed()) {
            orderList.removeAt(i)
        }
        Thread(networkTask).start();
        while(json_order == ""){
            var i=1
        }
        val json_object= JSONArray(json_order)
        for (i in 0..json_object.length()-1) {
            val a =
                order(json_object.getJSONObject(i).getString("p_name"),
                    json_object.getJSONObject(i).getString("tr_time"),
                    json_object.getJSONObject(i).getString("p_price"))
            orderList.add(a)

        }
    }
    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_order=hr.httprequestsOrder()
    }
}
