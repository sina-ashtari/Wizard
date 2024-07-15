package xyz.sina.wizard.model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getWise()

    companion object{
        private const val BASE_URL = "https://api.pawan.krd/v1/chat/completions"
        private const val API_KEY = "pk-UaOJcBGhRsNtHIkQExWyxYBiHoxTRChjwGkYNdlsvRCSoybd"
        fun create(): ApiService {
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
                ApiService::class.java)
        }
    }

}