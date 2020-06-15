package com.example.app.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.commodity


class commodityAdapter
    (private val mCommodityList: List<commodity>) :
    RecyclerView.Adapter<commodityAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onClick(position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var commodityImage: ImageView
        var commodityName: TextView
        var commodityDesc: TextView
        var commodityScore: TextView

        init {
            commodityImage = view.findViewById(R.id.image)
            commodityName = view.findViewById(R.id.namea)
            commodityDesc = view.findViewById(R.id.descripta)
            commodityScore = view.findViewById(R.id.scorea)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val com = mCommodityList[position]
        holder.commodityImage.setImageResource(com.picture)
        holder.commodityName.setText(com.name)
        holder.commodityDesc.setText(com.descript)
        holder.commodityScore.setText(com.score)

        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.commodityImage.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.commodityName.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.commodityDesc.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
        holder.commodityScore.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    // 用于告诉RecyclerView一共有多少子项，直接返回数据源长度
    override fun getItemCount(): Int {
        return mCommodityList.size
    }

}