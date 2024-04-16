package com.example.bai23_kotlin_firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai23_kotlin_firebase.databinding.EmpListItemBinding

class EmpAdapter(private var ds: ArrayList<EmployeeModel>) : RecyclerView.Adapter<EmpAdapter.ViewHolder>() {
    // Code adapter lắng nghe sự kiện
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener) {
        mListener = clickListener
    }

    // Tạo class ViewHolder
    class ViewHolder(val binding: EmpListItemBinding,clickListener: onItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EmpListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvEmpName.text = ds[position].empName
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
