package com.ranielschneider.cinescope.data.remote

import com.ranielschneider.cinescope.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response{

        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Bearer ${Constants.TOKEN}"
            )
            .build()
        return chain.proceed(request)
    }
}