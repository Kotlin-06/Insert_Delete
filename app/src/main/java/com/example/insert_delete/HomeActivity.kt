package com.example.insert_delete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnInsert.setOnClickListener{
            var name = edtVName.text.toString()
            var millage = edtVMillage.text.toString().toInt()
            var fuelcap = edtVFucap.text.toString().toInt()
            var vehicle = Vehicle(name,millage,fuelcap)
            var db = DBHelper(this)
            var flag = db.insert(vehicle)
            if(flag)
            {
                Toast.makeText(this, "Record Inserted Successfully", Toast.LENGTH_SHORT).show()
            }
        }

        btnViewAll.setOnClickListener{
            var intent = Intent(this,ViewAllActivity::class.java)
            startActivity(intent)
        }
    }

}
