package com.example.gmailapp_listview

import android.graphics.Color
import android.graphics.PorterDuff
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmailapp_listview.databinding.LayoutItemBinding

class RvAdapter(private var ds:List<MyData>):RecyclerView.Adapter<RvAdapter.MailViewHolder>() {

    private lateinit var rvAdapterBinding: LayoutItemBinding

    //viewholder
    inner class MailViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        rvAdapterBinding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MailViewHolder(rvAdapterBinding.root)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        rvAdapterBinding.iconText.text = "test"
        holder.itemView.apply {
            rvAdapterBinding.iconText.text = ds[position].iconText
            rvAdapterBinding.timeText.text = ds[position].timeText
            rvAdapterBinding.senderName.text = ds[position].senderName
            rvAdapterBinding.mailContent.text = ds[position].mailContent
            rvAdapterBinding.iconImage.setColorFilter(
                Color.parseColor(ds[position].color),   //chuyển mã hex color thành số (vì chỉ nhận Int)
                PorterDuff.Mode.SRC_IN
            )

        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}