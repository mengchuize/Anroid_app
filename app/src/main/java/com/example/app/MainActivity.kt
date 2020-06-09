package com.example.app

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.app.httprequests.httprequest
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray
import java.security.acl.Group


class MainActivity : AppCompatActivity() {

    var json_student = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("config", 0)

        val username = sp.getString("username","defValue")
        val score = sp.getString("score","defValue")
//        val drawer =
//            findViewById<View>(R.id.customDrawerLayout) as DrawerLayout
//        drawer.setScrimColor(Color.TRANSPARENT)
//
//        val toggle = ActionBarDrawerToggle(
//            this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawer.setDrawerListener(toggle)
//        toggle.syncState()
//
//
//        var navigationView: NavigationView
//        navigationView=findViewById( R.id.nav_view )
//        navigationView.setItemIconTintList( null )
//        Thread(networkTask).start();
//        while(json_student == ""){
//            var i=1
//        }
//        val json_object= JSONArray(json_student)
//
//        var o=-1
//        for(i in 0..json_object.length()-1){
//            if(json_object.getJSONObject(i).getString("user_name")==username)
//                o=i
//        }
//        val un=findViewById<TextView>(R.id.username)
//        val major=findViewById<TextView>(R.id.usermajor)
//        val classs=findViewById<TextView>(R.id.userclass)
//        val sc=findViewById<TextView>(R.id.userscore)
//        un.setText(json_object.getJSONObject(o).getString("user_name"))
//        major.setText(json_object.getJSONObject(o).getString("user_major"))
//        classs.setText(json_object.getJSONObject(o).getString("user_class"))
//        sc.setText(json_object.getJSONObject(o).getString("sore"))


        val shop=findViewById<ImageButton>(R.id.shop)
        val detial=findViewById<ImageButton>(R.id.detial)
        val order=findViewById<ImageButton>(R.id.order)
        val activity=findViewById<ImageButton>(R.id.activity)
        val signin=findViewById<TextView>(R.id.signin_textView)
        val points=findViewById<TextView>(R.id.points)
        points.setText(score)
        shop.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        })
        detial.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DetialActivity::class.java)
            startActivity(intent)
        })
        order.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        })
        activity.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActActivity::class.java)
            startActivity(intent)
        })
        signin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        })
    }

    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_student=hr.httprequestsUser()
    }


}
