package com.huxq17.example.mzitu

import com.huxq17.download.core.connection.DownloadConnection
import com.huxq17.download.core.connection.OkHttpDownloadConnection
import okhttp3.OkHttpClient
import okhttp3.Request

class AuthorizationHeaderConnection(okHttpClient: OkHttpClient?, requestBuilder: Request.Builder?) : OkHttpDownloadConnection(okHttpClient, requestBuilder) {
    class Factory(private val okHttpClient: OkHttpClient) : DownloadConnection.Factory {
        override fun create(requestBuilder: Request.Builder): DownloadConnection {
            return AuthorizationHeaderConnection(okHttpClient, requestBuilder)
        }
    }

    init {
        addHeader("accept-encoding", "gzip, deflate, br")
        addHeader("accept-language", "zh,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7")
        addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/png,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
        addHeader("user-agent", App.getUserAgent())
    }
}