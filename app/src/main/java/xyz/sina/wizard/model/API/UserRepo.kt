package xyz.sina.wizard.model.API

class UserRepo(private val apiService: ApiService) {
    suspend fun getWise() = apiService.getWise()

}