package com.insurtech.kanguro.ui.scenes.homeFaq

import androidx.lifecycle.viewModelScope
import com.insurtech.kanguro.common.enums.InformationTopics
import com.insurtech.kanguro.core.base.BaseViewModel
import com.insurtech.kanguro.core.utils.UiState
import com.insurtech.kanguro.data.Result
import com.insurtech.kanguro.data.repository.IAdvicesRepository
import com.insurtech.kanguro.designsystem.removeStartingNumbersAndPunctuation
import com.insurtech.kanguro.designsystem.ui.composables.faq.model.QuestionModel
import com.insurtech.kanguro.designsystem.ui.composables.homeFrequentlyAskedQuestions.model.HomeDashboardFaqModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFrequentlyAskedQuestionsViewModel @Inject constructor(
    private val advicesRepository: IAdvicesRepository
) : BaseViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<HomeDashboardFaqModel>>(UiState.Loading.ScreenLoader)
    val uiState = _uiState.asStateFlow()

    init {
        fetchFaq()
    }

    fun fetchFaq() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading.ScreenLoader

            var rentersFaq: List<QuestionModel> = emptyList()
            var petFaq: List<QuestionModel> = emptyList()

            when (
                val rentersResult =
                    advicesRepository.getAdvicesResult(InformationTopics.FAQRenters)
            ) {
                is Result.Success -> {
                    rentersFaq = rentersResult.data.map {
                        QuestionModel(
                            question = it.value?.removeStartingNumbersAndPunctuation().orEmpty(),
                            answer = it.description.orEmpty()
                        )
                    }
                }
                is Result.Error -> {
                    _uiState.value = UiState.Error()
                    return@launch
                }
            }

            when (
                val petResult = advicesRepository.getAdvicesResult(InformationTopics.FAQ)
            ) {
                is Result.Success -> {
                    petFaq = petResult.data.map {
                        QuestionModel(
                            question = it.value?.removeStartingNumbersAndPunctuation().orEmpty(),
                            answer = it.description.orEmpty()
                        )
                    }
                }
                is Result.Error -> {
                    _uiState.value = UiState.Error()
                    return@launch
                }
            }

            val model = HomeDashboardFaqModel(
                rentersFaq = rentersFaq,
                petFaq = petFaq
            )

            _uiState.value = UiState.Success(model)
        }
    }
}
