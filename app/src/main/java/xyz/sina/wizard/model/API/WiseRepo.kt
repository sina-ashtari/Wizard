package xyz.sina.wizard.model.API

class WiseRepo(private val apiService: ApiService) {
    suspend fun getWise() = apiService.getWise()

}