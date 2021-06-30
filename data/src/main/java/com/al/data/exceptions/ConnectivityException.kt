package com.al.data.exceptions

import java.io.IOException


class ConnectivityException(override var message: String = "No internet connection, please check network adaptors.") : IOException(message)