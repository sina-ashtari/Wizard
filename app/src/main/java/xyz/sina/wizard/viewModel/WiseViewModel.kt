package xyz.sina.wizard.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import xyz.sina.wizard.model.API.Json.Wise
import xyz.sina.wizard.model.API.WiseRepo

class WiseViewModel(private val repo: WiseRepo):ViewModel (){
    private val _wise = MutableStateFlow<Wise?>(null)
    val wise : StateFlow<Wise?> = _wise

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchWise(){
        viewModelScope.launch {
            val result = repo.getWise()
            if(result.isSuccess){
                _wise.value = result.getOrNull()
            }else{
                _errorMessage.value = result.exceptionOrNull()?.message
            }

        }
    }
}