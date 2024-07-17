package xyz.sina.wizard.model.DI

import xyz.sina.wizard.model.API.ApiService
import xyz.sina.wizard.model.API.WiseRepo
import xyz.sina.wizard.viewModel.WiseViewModel

object Injection {
    // TODO : use hilt
    fun provideWiseViewModel(): WiseViewModel {
        val apiService = ApiService.create()
        val repository = WiseRepo(apiService)
        return WiseViewModel(repository)
    }
}