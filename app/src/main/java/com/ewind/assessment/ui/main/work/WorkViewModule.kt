package com.ewind.assessment.ui.main.work

import com.ewind.assessment.R
import com.ewind.assessment.ui.main.base.BaseViewModel
import com.ewind.assessment.util.googlemap.GoogleMapCallback
import com.ewind.assessment.util.googlemap.GoogleMapManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng

class WorkViewModule(val googleMapManager: GoogleMapManager) : BaseViewModel() {

    private var latLng: LatLng? = null

    fun setLocation(latLng: LatLng) {
        this.latLng = latLng
    }

    fun initMap(mapView: MapView) {
        googleMapManager.initializeMap(mapView)
        googleMapManager.setMapCallback(object : GoogleMapCallback {
            override fun mapOnReadyCallback(googleMap: GoogleMap) {
                super.mapOnReadyCallback(googleMap)
                googleMap.uiSettings.isScrollGesturesEnabled= false
                latLng?.let {
                    googleMapManager.setMarkers(it, R.drawable.pin, false, "s")
                    googleMapManager.setCamera(it, GoogleMapManager.DEFAULT_ZOOM)
                }
            }
        })
    }

    override fun start() {

    }

    override fun stop() {

    }
}