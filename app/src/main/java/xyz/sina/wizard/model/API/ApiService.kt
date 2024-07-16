package xyz.sina.wizard.model.API

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    // fix this shit from API
    @GET("")
    suspend fun getWise(@Query(API_KEY) key : String ) :Response<String>
    @POST("")
    suspend fun sendReq()

    companion object{
        private const val BASE_URL = "https://api.pawan.krd/v1/chat/completions"
        private const val API_KEY = "pk-UaOJcBGhRsNtHIkQExWyxYBiHoxTRChjwGkYNdlsvRCSoybd"
        fun create(): ApiService {
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
                ApiService::class.java)
        }
    }

}