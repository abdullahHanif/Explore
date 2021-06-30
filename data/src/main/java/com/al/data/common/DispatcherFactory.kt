package com.al.data.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T> runOnBackgroundDispatcher(crossinline call: suspend () -> T) =
    withContext(Dispatchers.Default) {
        call()
    }