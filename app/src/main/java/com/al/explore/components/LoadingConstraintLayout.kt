package com.al.explore.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.al.explore.R
import com.wang.avi.AVLoadingIndicatorView


class LoadingConstraintLayout : ConstraintLayout {
    //
    private lateinit var loaderView: ConstraintLayout
    private lateinit var loader: AVLoadingIndicatorView

    //if you add your View from xml and also specify the android:style attribute like : <com.mypack.MyView style="@styles/MyCustomStyle" />
    //you will also need the first constructor public MyView(Context context, AttributeSet attrs,int defStyle)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    //you will need the constructor public MyView(Context context, AttributeSet attrs), otherwise you will get an Exception when Android tries to inflate your View.
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    //The third constructor is usually used when you extend a style and customize it, and then you would like to set that style to a given View in your layouts
    constructor(context: Context) : super(context) {
        init()
    }

    fun init() {
        inflate(context, R.layout.loader, this)
        loaderView = findViewById(R.id.loaderView)
        loader = findViewById(R.id.loader)
    }


    fun showLoader() {
        loaderView.visibility = View.VISIBLE
    }

    fun hideLoader() {
        loaderView.visibility = View.GONE
    }
}