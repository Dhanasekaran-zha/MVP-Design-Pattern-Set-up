package com.ds.kotlin_mvp_designpattern.utils

import android.util.Base64

object SecurityUtils {

    fun getBase64EncodeData(data: ByteArray): String {
        return Base64.encodeToString(data, Base64.NO_WRAP)
    }

    fun convertToBase64(attachment: ByteArray): String {
        return getBase64EncodeData(attachment)
    }
}
