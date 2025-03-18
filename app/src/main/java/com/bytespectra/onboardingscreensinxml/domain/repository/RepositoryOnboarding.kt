package com.bytespectra.onboardingscreensinxml.domain.repository

import com.bytespectra.onboardingscreensinxml.data.DpOnboarding
import com.bytespectra.onboardingscreensinxml.domain.model.OnboardingModel

class RepositoryOnboarding() {
    fun getData(): List<OnboardingModel> {
        return DpOnboarding().dataList
    }
}