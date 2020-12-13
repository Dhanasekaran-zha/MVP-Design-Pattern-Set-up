package com.ds.kotlin_mvp_designpattern.app

import android.app.Application
import com.ds.kotlin_mvp_designpattern.data.repo.AdminRepo
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppController : Application() {

    companion object {
        var appController: AppController? = null

        fun getInstanse(): AppController? {
            return appController
        }
    }

    private var adminRepo: AdminRepo? = null
    private var gson: Gson? = null

    override fun onCreate() {
        super.onCreate()
        appController = this
        gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

    }


    fun getAdminRepo(): AdminRepo {
        if (adminRepo == null) adminRepo = createAdminRepo()
        return this.adminRepo!!
    }

    private fun createAdminRepo(): AdminRepo {
        val retrofit: Retrofit
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        retrofit = Retrofit.Builder().client(httpClient)
                .baseUrl(ApiUrl.EMP_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

        return AdminRepo(retrofit.create(SampleApi::class.java))
    }
}