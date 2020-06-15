package com.example.app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.activity.ProductActivity
import com.example.app.adapter.commodityAdapter
import com.example.app.httprequests.httprequest
import com.example.app.models.commodity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.util.ArrayList

class ShopActivity : AppCompatActivity() {

    private val commodityList: MutableList<commodity> = ArrayList<commodity>()
    private val imageList: MutableList<Int> = ArrayList<Int>()
    var json_product=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        imageList.add(R.drawable.p1)
        imageList.add(R.drawable.p2)
        imageList.add(R.drawable.p3)
        imageList.add(R.drawable.p4)
        val back: ImageButton = findViewById(R.id.back_button)
        back.setOnClickListener(View.OnClickListener {
//            this.finish()
            val intent = Intent(this@ShopActivity, MainActivity::class.java)
            startActivity(intent)
        })

        initCommodity()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_shop)
        recyclerView.removeAllViews()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = commodityAdapter(commodityList)

        adapter.setOnItemClickListener(object : commodityAdapter.OnItemClickListener {
            override fun onClick(position: Int) {
                val json_object= JSONArray(json_product)
                val sp = getSharedPreferences("config", 0)
                val editor: SharedPreferences.Editor = sp.edit()
                when (position) {
                    0 -> {
                        val s=sp.getString("score","default").toInt()
                        val r=s-json_object.getJSONObject(0).getString("p_price").toInt()
                        editor.putString("score",r.toString())
                        editor.putString("productImage", "0")
                        editor.putString("productName", json_object.getJSONObject(0).getString("p_name"))
                        editor.putString("productDescription", json_object.getJSONObject(0).getString("p_description"))
                        editor.putString("productPrice", json_object.getJSONObject(0).getString("p_price"))

                        editor.commit()
                        val intent = Intent(this@ShopActivity, ProductActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val s=sp.getString("score","default").toInt()
                        val r=s-json_object.getJSONObject(1).getString("p_price").toInt()
                        editor.putString("score",r.toString())
                        editor.putString("productImage", "0")
                        editor.putString("productName", json_object.getJSONObject(1).getString("p_name"))
                        editor.putString("productDescription", json_object.getJSONObject(1).getString("p_description"))
                        editor.putString("productPrice", json_object.getJSONObject(1).getString("p_price"))
                        editor.commit()
                        val intent = Intent(this@ShopActivity, ProductActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val s=sp.getString("score","default").toInt()
                        val r=s-json_object.getJSONObject(2).getString("p_price").toInt()
                        editor.putString("score",r.toString())
                        editor.putString("productImage", "0")
                        editor.putString("productName", json_object.getJSONObject(2).getString("p_name"))
                        editor.putString("productDescription", json_object.getJSONObject(2).getString("p_description"))
                        editor.putString("productPrice", json_object.getJSONObject(2).getString("p_price"))
                        editor.commit()
                        val intent = Intent(this@ShopActivity, ProductActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val s=sp.getString("score","default").toInt()
                        val r=s-json_object.getJSONObject(3).getString("p_price").toInt()
                        editor.putString("score",r.toString())
                        editor.putString("productImage", "0")
                        editor.putString("productName", json_object.getJSONObject(3).getString("p_name"))
                        editor.putString("productDescription", json_object.getJSONObject(3).getString("p_description"))
                        editor.putString("productPrice", json_object.getJSONObject(3).getString("p_price"))
                        editor.commit()
                        val intent = Intent(this@ShopActivity, ProductActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
        recyclerView.adapter = adapter
    }
    fun initCommodity(){
        for (i in commodityList.indices.reversed()) {
            commodityList.removeAt(i)
        }
        Thread(networkTask).start();
        while(json_product == ""){
            var i=1
        }
        val json_object= JSONArray(json_product)
        for (i in 0..json_object.length()-1) {
            val a =
                commodity(imageList[i],
                    json_object.getJSONObject(i).getString("p_name"),
                    json_object.getJSONObject(i).getString("p_description"),
                    json_object.getJSONObject(i).getString("p_price"))
            commodityList.add(a)

        }
    }

    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_product=hr.httprequestsProduct()
    }
}
