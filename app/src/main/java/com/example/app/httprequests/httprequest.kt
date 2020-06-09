package com.example.app.httprequests

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

class httprequest{

    fun  httprequestsUser():String{
        val urltext="http://49.234.76.144:5566/user"

        val json = StringBuilder()
        try {
            val urlObject = URL(urltext)
            val uc: URLConnection = urlObject.openConnection()
            val inbuff =
                BufferedReader(InputStreamReader(uc.getInputStream(), "UTF-8"))
            var inputLine: String? = null
            while (inbuff.readLine().also({ inputLine = it }) != null) {
                json.append(inputLine)
            }
            inbuff.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        System.out.println("data");
        System.out.println(json.toString())
        return json.toString()
    }
    fun  httprequestsProduct():String{
        val urltext="http://49.234.76.144:5566/product"

        val json = StringBuilder()
        try {
            val urlObject = URL(urltext)
            val uc: URLConnection = urlObject.openConnection()
            val inbuff =
                BufferedReader(InputStreamReader(uc.getInputStream(), "UTF-8"))
            var inputLine: String? = null
            while (inbuff.readLine().also({ inputLine = it }) != null) {
                json.append(inputLine)
            }
            inbuff.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        System.out.println("data");
        System.out.println(json.toString())
        return json.toString()
    }

    fun  httprequestsOrder():String{
        val urltext="http://49.234.76.144:5566/transaction"

        val json = StringBuilder()
        try {
            val urlObject = URL(urltext)
            val uc: URLConnection = urlObject.openConnection()
            val inbuff =
                BufferedReader(InputStreamReader(uc.getInputStream(), "UTF-8"))
            var inputLine: String? = null
            while (inbuff.readLine().also({ inputLine = it }) != null) {
                json.append(inputLine)
            }
            inbuff.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        System.out.println("data");
        System.out.println(json.toString())
        return json.toString()
    }

    fun  httprequestsDetail():String{
        val urltext="http://49.234.76.144:5566/transaction"

        val json = StringBuilder()
        try {
            val urlObject = URL(urltext)
            val uc: URLConnection = urlObject.openConnection()
            val inbuff =
                BufferedReader(InputStreamReader(uc.getInputStream(), "UTF-8"))
            var inputLine: String? = null
            while (inbuff.readLine().also({ inputLine = it }) != null) {
                json.append(inputLine)
            }
            inbuff.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        System.out.println("data");
        System.out.println(json.toString())
        return json.toString()
    }

    fun  httprequestsActivity():String{
        val urltext="http://49.234.76.144:5566/activity"

        val json = StringBuilder()
        try {
            val urlObject = URL(urltext)
            val uc: URLConnection = urlObject.openConnection()
            val inbuff =
                BufferedReader(InputStreamReader(uc.getInputStream(), "UTF-8"))
            var inputLine: String? = null
            while (inbuff.readLine().also({ inputLine = it }) != null) {
                json.append(inputLine)
            }
            inbuff.close()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        System.out.println("data");
        System.out.println(json.toString())
        return json.toString()
    }

}