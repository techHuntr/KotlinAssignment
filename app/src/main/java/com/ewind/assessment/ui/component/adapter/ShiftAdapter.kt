package com.ewind.assessment.ui.component.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ewind.assessment.data.remote.model.Shift
import com.ewind.assessment.domain.model.DShift
import com.ewind.assessment.util.ext.EE_DD_MMM
import com.ewind.assessment.util.ext.inflate
import com.ewind.assessment.util.ext.toCustomDate
import kotlinx.android.synthetic.main.item_shift.view.*
import kotlinx.android.synthetic.main.item_work.view.*
import kotlinx.android.synthetic.main.item_work.view.tv_date
import java.util.*

class ShiftAdapter(val shiftList: MutableList<DShift>) :
    RecyclerView.Adapter<ShiftAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(com.ewind.assessment.R.layout.item_shift, false))
    }

    override fun getItemCount(): Int = shiftList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.run { onBind(position) }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {

            val shift = shiftList[position]
            itemView.tv_date.text = shift.startDate?.toCustomDate(EE_DD_MMM)
            itemView.tv_time.text = "${shift.startTime} - ${shift.endTime}"
            val currencyCode = Currency.getInstance(shift.currency).symbol
            itemView.tv_price.text =
                "$currencyCode ${String.format("%.2f", shift.earningsPerHour)}"

        }
    }

    fun clearDate() {
        shiftList.clear()
        notifyDataSetChanged()
    }

    fun addWorks(list: MutableList<DShift>) {
        shiftList.addAll(list)
        notifyDataSetChanged()
    }
}