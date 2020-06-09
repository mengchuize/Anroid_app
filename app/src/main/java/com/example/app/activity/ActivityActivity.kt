package com.example.app.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.app.R
import com.example.app.models.commodity
import com.example.app.upload.uploadProduct
import com.example.app.upload.uploadjoin

class ActivityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)
        val sp = getSharedPreferences("config", 0)

        val username = sp.getString("username","defValue")
        val activityName = sp.getString("activityName","defValue")
        val activityPrice = sp.getString("activityPrice","defValue")
        val activityDescription = sp.getString("activityDescription","defValue")

        val viewImage=findViewById<ImageView>(R.id.pimage)
        val viewName=findViewById<TextView>(R.id.pname)
        val viewPrice=findViewById<TextView>(R.id.pprice)
        val viewDesc=findViewById<TextView>(R.id.pdesc)

        viewName.setText(activityName)
        viewPrice.setText(activityPrice)
        viewDesc.setText(activityDescription)

        val buy=findViewById<Button>(R.id.buy)
        buy.setOnClickListener(View.OnClickListener {
            "参加成功！".toast(this,1000)
            val up: uploadjoin = uploadjoin()

            var cc: commodity = commodity(0,username,activityName,"0")
            up.initUploadBase("http://49.234.76.144:5566",cc)
        })

    }
    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }
}
