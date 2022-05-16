package com.example.googlemapapp

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapapp.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private var markerSydney: Marker? = null
    private var markerTokyo: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        var currentMarker: Marker? = null
        //FusedLocationProviderClientとは位置情報を衛星から取得する際には時間がかかるため、自動的に
        //WIFIとうに接続を切り替え、取得のスピードをあげることができる
        var fusedLocationProviderClient: FusedLocationProviderClient? = null
        var currentLocation: Location? = null

        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnMapClickListener (object: GoogleMap.OnMapClickListener {
            override fun onMapClick(latlng: LatLng) {
                val clickedLocation = LatLng(latlng.latitude, latlng.longitude)

                mMap.clear()
                mMap.addMarker(
                    MarkerOptions()
                        .position(clickedLocation)


                )}

        })
        }







    override fun onMarkerClick(p0: Marker): Boolean {
        TODO("Not yet implemented")
    }

}
