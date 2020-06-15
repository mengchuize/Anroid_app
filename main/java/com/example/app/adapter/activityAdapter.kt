package com.example.app.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.activity


class activityAdapter
    (private val mActivityList: List<activity>) :
    RecyclerView.Adapter<activityAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var activityName: TextView
        var activityScore: TextView
        var activityDesc: TextView
        init {

            activityName = view.findViewById(R.id.namea)
            activityScore = view.findViewById(R.id.scorea)
            activityDesc = view.findViewById(R.id.descripta)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val det = mActivityList[position]
        holder.activityName.setText(det.name)
        holder.activityDesc.setText(det.descript)
        holder.activityScore.setText(det.score)
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.activityName.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.activityDesc.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.activityScore.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    // 用于告诉RecyclerView一共有多少子项，直接返回数据源长度
    override fun getItemCount(): Int {
        return mActivityList.size
    }

}