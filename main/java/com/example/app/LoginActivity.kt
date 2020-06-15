package com.example.app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.app.httprequests.httprequest
import org.json.JSONArray

class LoginActivity : AppCompatActivity() {

    var json_user=""
    var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernametext=findViewById<EditText>(R.id.usernameeditText)
        val passwordtext=findViewById<EditText>(R.id.passwordeditText)
        val loginbutton=findViewById<Button>(R.id.loginbutton)

        loginbutton.setOnClickListener(View.OnClickListener {
            val username=usernametext.text.toString()
            val password=passwordtext.text.toString()

            Thread(networkTask).start();
            while(json_user == ""){
                var i=1
            }
            //json数据处理
            var m=-1;
            val json_object= JSONArray(json_user)
            for(i in 0..json_object.length()-1){
                if(json_object.getJSONObject(i).getString("user_name")==username&&json_object.getJSONObject(i).getString("user_password")==password){
                    m=i
                }
            }

            if (m!=-1){

                val sp = getSharedPreferences("config", 0)
                val editor: SharedPreferences.Editor = sp.edit()
                var score=json_object.getJSONObject(m).getString("score")
                editor.putString("username", username)
                editor.putString("score", score)
                editor.commit()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                json_user=""
                startActivity(intent)

            }else{
                "用户名或密码错误！".toast(this,1000)
            }
        })


    }
    fun logincheck(username:String,password:String):Int{


        return 1
    }
    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }
    var networkTask = Runnable {
        // TODO
        // 在这里进行 http request.网络请求相关操作
        var hr= httprequest()
        json_user=hr.httprequestsUser()
    }
}