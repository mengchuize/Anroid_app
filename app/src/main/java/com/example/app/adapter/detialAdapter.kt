package com.example.app.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.detial


class detialAdapter
    (private val mDetialList: List<detial>) :
    RecyclerView.Adapter<detialAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var detialName: TextView
        var detialTime: TextView
        var detialScore: TextView

        init {

            detialTime = view.findViewById(R.id.changetime)
            detialScore = view.findViewById(R.id.changescore)
            detialName = view.findViewById(R.id.changename)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.detial_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val det = mDetialList[position]
        holder.detialName.setText(det.name)
        holder.detialTime.setText(det.time)
        holder.detialScore.setText(det.score.toString())

        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.detialName.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.detialTime.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.detialScore.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    // 用于告诉RecyclerView一共有多少子项，直接返回数据源长度
    override fun getItemCount(): Int {
        return mDetialList.size
    }

}