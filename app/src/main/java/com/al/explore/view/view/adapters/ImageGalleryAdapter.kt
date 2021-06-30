package com.al.explore.view.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.al.domain.entity.ImageEntity
import com.al.explore.R
import com.al.explore.databinding.LiImageGalleryViewBinding

class ImageGalleryAdapter(var list: ArrayList<ImageEntity>, var onClick: (Int) -> Unit = {}) :
    RecyclerView.Adapter<ImageGalleryAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: LiImageGalleryViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<LiImageGalleryViewBinding>(
            LayoutInflater.from(parent.context), R.layout.li_image_gallery_view, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.model = item
        holder.binding.root.setOnClickListener { onClick(position) }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = list.size
}