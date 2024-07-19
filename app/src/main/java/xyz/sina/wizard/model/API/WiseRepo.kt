package xyz.sina.wizard.model.API

import retrofit2.HttpException
import xyz.sina.wizard.model.API.Json.Wise
import java.io.IOException

class WiseRepo(private val apiService: ApiService) {
    suspend fun getWise() : Result<Wise>{

        return try{
            val response = apiService.getWise()
            Result.success(response)
        }catch (e: HttpException){
            Result.failure(e)
        }catch (e: IOException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

}