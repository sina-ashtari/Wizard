package xyz.sina.wizard.model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import xyz.sina.wizard.model.API.Json.Wise

interface ApiService {
    // fix this shit from API
    @GET("random")
    suspend fun getWise() : Wise


    companion object{
        private const val BASE_URL = "https://api.quotable.io/"

        fun create(): ApiService {
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
                ApiService::class.java)
        }
    }

}