package com.al.explore.view.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.al.domain.entity.ImageEntity
import com.al.explore.R
import com.al.explore.base.BaseFragment
import com.al.explore.binding_adapters.loadImage
import com.al.explore.databinding.FragmentGalleryViewBinding
import com.al.explore.view.view.adapters.ImageGalleryAdapter
import com.al.explore.view.viewmodel.ImageGalleryEvents
import com.al.explore.view.viewmodel.ImageGalleryViewModel
import com.paginate.Paginate
import com.stfalcon.imageviewer.StfalconImageViewer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageGalleryView : BaseFragment() {

    lateinit var binding: FragmentGalleryViewBinding
    val viewModel: ImageGalleryViewModel by viewModels()

    lateinit var adpater: ImageGalleryAdapter

    override fun showLoader() {
        TODO("Not yet implemented")
    }

    override fun hideLoader() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_gallery_view, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        initAdapter(viewModel.imageList)
        setObservers()
    }

    private fun setObservers() {
        viewModel.obEvents.observe(viewLifecycleOwner, Observer {
            val event = it.getEventIfNotHandled()
            when (event) {
                ImageGalleryEvents.NotifyChanges -> adpater?.notifyDataSetChanged()
                ImageGalleryEvents.NoDataFound -> binding.noInternet.visibility = View.VISIBLE
            }
        })
    }

    private fun initialize() {
        viewModel.fetchImageGallery(1)
    }

    private fun initAdapter(list: ArrayList<ImageEntity>) {
        adpater = ImageGalleryAdapter(list) {
            StfalconImageViewer.Builder<ImageEntity>(context, list) { view, image ->
                view.loadImage(image.largeImageURL)
            }.withStartPosition(it)
                .withBackgroundColor(ContextCompat.getColor(requireContext(), R.color.transparent))
                .withHiddenStatusBar(false).show()
        }

        val grid = GridLayoutManager(requireContext(), 2)
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val mod = position % 6
                return if (position == 0 || position == 1) 2 else if (position < 6) 1 else if (mod == 0 || mod == 1) 2 else 1
            }
        }
        binding.rvGallery.layoutManager = grid
        binding.rvGallery.adapter = adpater

        Paginate.with(binding.rvGallery, viewModel)
            .setLoadingTriggerThreshold(2)
            .addLoadingListItem(true)
            .build()
    }
}