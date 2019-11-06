package com.ewind.assessment.ui.main.work

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ewind.assessment.R
import com.ewind.assessment.domain.model.DLocation
import com.ewind.assessment.domain.model.DShift
import com.ewind.assessment.ui.component.adapter.ShiftAdapter
import com.ewind.assessment.ui.main.base.BaseActivity
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_work.*
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_NAME = "name"
const val EXTRA_SHIFT = "shift"
const val EXTRA_LOCATIONS = "location"

class WorkActivity : BaseActivity() {

    private val viewMod by viewModel<WorkViewModule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        mv_work.onCreate(savedInstanceState)

        val location = intent.extras?.getParcelable<DLocation>(EXTRA_LOCATIONS)
        val name = intent.extras?.getString(EXTRA_NAME)
        val shifts = intent.extras?.getParcelableArrayList<DShift>(EXTRA_SHIFT)

        supportActionBar?.title = name

        location?.lng?.toDoubleOrNull()?.let {
            location.lat?.toDoubleOrNull()?.let { it1 ->
                LatLng(
                    it1,
                    it
                )
            }
        }?.let { viewMod.setLocation(it) }
        viewMod.initMap(mv_work)

        rv_sift.layoutManager = LinearLayoutManager(this)
        if (!shifts.isNullOrEmpty()) {
            rv_sift.adapter = ShiftAdapter(shifts.toMutableList())
        }
    }

    override fun onStart() {
        super.onStart()
        mv_work.onStart()
    }

    override fun onResume() {
        super.onResume()
        mv_work.onResume()
    }

    override fun onPause() {
        super.onPause()
        mv_work.onPause()
    }

    override fun onStop() {
        super.onStop()
        mv_work.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mv_work.onDestroy()
    }
}
