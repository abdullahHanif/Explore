package com.al.explore.view.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.al.explore.R
import com.al.explore.base.BaseActivity
import com.al.explore.databinding.ActivityMainBinding
import com.al.explore.extension.addFragment
import com.al.explore.view.view.fragments.ImageGalleryView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun showLoader() {
        binding.rootView.showLoader()
    }

    override fun hideLoader() {
        binding.rootView.hideLoader()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        addFragment(R.id.container, ImageGalleryView(), addToBackStack = false)
    }
}