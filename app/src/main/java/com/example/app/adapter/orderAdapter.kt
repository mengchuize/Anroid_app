package com.example.app.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.detial
import com.example.app.models.order


class orderAdapter
    (private val mOrderList: List<order>) :
    RecyclerView.Adapter<orderAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var orderName: TextView
        var orderTime: TextView
        var orderScore:TextView

        init {

            orderName = view.findViewById(R.id.ordername)
            orderTime = view.findViewById(R.id.ordertime)
            orderScore=view.findViewById(R.id.trscore)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val det = mOrderList[position]
        holder.orderName.setText(det.ordername)
        holder.orderTime.setText(det.ordertime)
        holder.orderScore.setText(det.orderscore)

        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.orderName.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.orderTime.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.orderScore.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    // 用于告诉RecyclerView一共有多少子项，直接返回数据源长度
    override fun getItemCount(): Int {
        return mOrderList.size
    }

}