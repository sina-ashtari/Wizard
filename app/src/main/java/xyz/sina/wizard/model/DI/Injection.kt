package xyz.sina.wizard.model.DI

import xyz.sina.wizard.model.API.ApiService
import xyz.sina.wizard.model.API.WiseRepo
import xyz.sina.wizard.viewModel.WiseViewModel
import javax.inject.Inject

object Injection {
    fun provideWiseViewModel(): WiseViewModel {
        val apiService = ApiService.create()
        val repository = WiseRepo(apiService)
        return WiseViewModel(repository)
    }
}