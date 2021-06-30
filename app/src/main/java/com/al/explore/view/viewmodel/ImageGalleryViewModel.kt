package com.al.explore.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.al.domain.entity.ImageEntity
import com.al.domain.usecase.FetchImageCase
import com.al.explore.base.BaseEvent
import com.paginate.Paginate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageGalleryViewModel @Inject constructor(private val fetchImageCase: FetchImageCase) :
    ViewModel(), Paginate.Callbacks {

    private var hasLoadedAllItems: Boolean = false
    private var isLoading: Boolean = false
    private var pageNo: Int = 1
    private var perPage = 20

    val imageList = ArrayList<ImageEntity>()

    private val events = MutableLiveData<BaseEvent<ImageGalleryEvents>>()
    val obEvents: LiveData<BaseEvent<ImageGalleryEvents>> = events

     fun fetchImageGallery(page: Int) {
        viewModelScope.launch {

            fetchImageCase(page)
                .catch {
                    isLoading = false
                    hasLoadedAllItems = true
                    events.value = BaseEvent(ImageGalleryEvents.NotifyChanges)
                    if (imageList.isNullOrEmpty())
                        events.value = BaseEvent(ImageGalleryEvents.NoDataFound)
                }.collect {
                    isLoading = false
                    hasLoadedAllItems = (it.size / perPage) <= pageNo

                    imageList.addAll(it)
                    pageNo++
                    events.value = BaseEvent(ImageGalleryEvents.NotifyChanges)

                }
        }
    }

    override fun onLoadMore() {
        isLoading = true
        fetchImageGallery(pageNo)
    }

    override fun isLoading() = isLoading

    override fun hasLoadedAllItems() = hasLoadedAllItems
}


sealed class ImageGalleryEvents {
    object NotifyChanges : ImageGalleryEvents()
    object NoDataFound : ImageGalleryEvents()
}