package com.example.insert_delete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        refreshRecycler()

    }

    private fun refreshRecycler() {
        var db=DBHelper(this)
        var arr=db.retriveAll()
        var vehicleadapter = VehicleAdapter(this,arr)
        myrecycle.adapter = vehicleadapter
    }
    fun delete(position:Int)
    {
        var db=DBHelper(this)
        var arr:ArrayList<Vehicle> = db.retriveAll()
        var vehicle=arr.get(position)
        db.delete(vehicle.v_id)
        refreshRecycler()
    }

}