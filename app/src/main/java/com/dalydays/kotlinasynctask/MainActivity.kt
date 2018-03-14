package com.dalydays.kotlinasynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // execute AsyncTask, send in Int value as the limit to count up to
        GetFizzBuzzTask().execute(100)
    }

    class GetFizzBuzzTask : AsyncTask<Int, Void, String>() {

        override fun doInBackground(vararg p0: Int?): String {
            var result = ""
            for (i in 1..p0[0]!!) {
                var currentString = ""
                if (i % 3 == 0)
                    currentString += "fizz"
                if (i % 5 == 0)
                    currentString += "buzz"
                if (currentString.isEmpty())
                    currentString += i.toString()
                result += currentString + ","
            }
            println("printing in a background thread")
            println(result)
            return result
        }

        override fun onPostExecute(result: String?) {
            println("printing on the main UI thread")
            println(result)
        }
    }
}
