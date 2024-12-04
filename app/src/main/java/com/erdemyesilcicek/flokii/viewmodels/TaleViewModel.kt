package com.erdemyesilcicek.flokii.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdemyesilcicek.flokii.datas.dataclass.AiTaleModel

class TaleViewModel : ViewModel() {
    private val _aiTaleModel = MutableLiveData<AiTaleModel>()
    val aiTaleModel: LiveData<AiTaleModel> get() = _aiTaleModel

    fun updateAiPromptModel(newModel: AiTaleModel) {
        _aiTaleModel.value = newModel
    }
}