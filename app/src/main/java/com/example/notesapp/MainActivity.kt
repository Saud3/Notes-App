package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var rvMain:RecyclerView
    lateinit var message: ArrayList<String>
    lateinit var etMessage: EditText
    lateinit var btSubmit : Button

    var notes = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        etMessage = findViewById(R.id.etMessage)
        btSubmit = findViewById(R.id.btSubmit)


        message = arrayListOf()

        btSubmit.setOnClickListener {
            notes = etMessage.text.toString()
            message.add(notes)
            rvMain.adapter = RVAdapter(message)
            rvMain.adapter!!.notifyDataSetChanged()

            var dbHelper = DBHelper(applicationContext)
            dbHelper.savedata(notes)
            Toast.makeText(applicationContext,"data saved successfully", Toast.LENGTH_SHORT).show()
        }




    }
}