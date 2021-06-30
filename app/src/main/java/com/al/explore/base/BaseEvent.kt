package com.al.explore.base

class BaseEvent<out T>(private val data: T?) {

    private var hasBeenHandled = false

    /**
     * Returns the live data content and prevents its use again.
     */
    fun getEventIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }
}