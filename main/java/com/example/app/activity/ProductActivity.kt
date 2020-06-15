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
import com.example.app.models.activity
import com.example.app.models.commodity
import com.example.app.upload.uploadActivity
import com.example.app.upload.uploadProduct

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val sp = getSharedPreferences("config", 0)

        val username = sp.getString("username","defValue")
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+username)

        val productImage = sp.getString("productImage","defValue")
        val productName = sp.getString("productName","defValue")
        val productPrice = sp.getString("productPrice","defValue")
        val productDescription = sp.getString("productDescription","defValue")

        val viewImage=findViewById<ImageView>(R.id.pimage)
        val viewName=findViewById<TextView>(R.id.pname)
        val viewPrice=findViewById<TextView>(R.id.pprice)
        val viewDesc=findViewById<TextView>(R.id.pdesc)
         when(productImage){
             "0"->{
                 viewImage.setImageResource(R.drawable.p1)
             }
             "1"->{
                 viewImage.setImageResource(R.drawable.p2)
             }
             "2"->{
                 viewImage.setImageResource(R.drawable.p3)
             }
             "3"->{
                 viewImage.setImageResource(R.drawable.p4)
             }

         }
        viewName.setText(productName)
        viewPrice.setText(productPrice)
        viewDesc.setText(productDescription)

        val buy=findViewById<Button>(R.id.buy)
        buy.setOnClickListener(View.OnClickListener {
            "购买成功！".toast(this,1000)
            val up: uploadProduct = uploadProduct()
            var cc:commodity= commodity(0,username,productName,"0")
            up.initUploadBase("http://49.234.76.144:5566",cc)
        })

    }
    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }
}
