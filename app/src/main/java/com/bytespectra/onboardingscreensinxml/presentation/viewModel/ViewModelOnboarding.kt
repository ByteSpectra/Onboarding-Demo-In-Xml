package com.bytespectra.onboardingscreensinxml.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.bytespectra.onboardingscreensinxml.domain.model.OnboardingModel
import com.bytespectra.onboardingscreensinxml.domain.repository.RepositoryOnboarding

class ViewModelOnboarding: ViewModel() {

    private val repository: RepositoryOnboarding by lazy { RepositoryOnboarding() }

    fun fetchScreensData(): List<OnboardingModel> {
        return repository.getData()
    }

}