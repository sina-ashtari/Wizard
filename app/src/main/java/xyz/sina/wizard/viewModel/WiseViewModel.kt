package xyz.sina.wizard.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.sina.wizard.model.API.UserRepo

class WiseViewModel(private val repo: UserRepo):ViewModel (){

    fun fetchWise(){
        viewModelScope.launch {
            val wiseList = repo.getWise()
        }
    }
}