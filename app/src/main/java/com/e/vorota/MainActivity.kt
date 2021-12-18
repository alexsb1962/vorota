package com.e.vorota

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var  locationManager: LocationManager
    lateinit var locationListener:LocationListener
    lateinit var context: Context
    lateinit var tvEnabledGPS: TextView
    lateinit var bigText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context=getApplicationContext()
        val onoffBtn = findViewById(R.id.OnOffBtn) as Button
        val openBtn = findViewById(R.id.OpenBTN) as Button
        tvEnabledGPS =  findViewById(R.id.tvEnabledGPS)
        bigText =  findViewById(R.id.bigText)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener= Listener()

        onoffBtn.setOnClickListener{

        }
    }

    override fun onResume() {
        super.onResume()
        locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 100.0F, locationListener )
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 200F, locationListener )
        checkEnabled()
    }

    private fun checkEnabled() {
        tvEnabledGPS.setText("ToDo checkEnabled")
    }
}

class Listener: LocationListener {
    override fun onLocationChanged(location: Location) {
    }
}

