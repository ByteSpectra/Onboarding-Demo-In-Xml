package com.bytespectra.onboardingscreensinxml.data

import com.bytespectra.onboardingscreensinxml.R
import com.bytespectra.onboardingscreensinxml.domain.model.OnboardingModel

class DpOnboarding {

    val dataList = listOf(
        OnboardingModel(image = R.drawable.img_onboarding_screen_first, "First Screen Title"),
        OnboardingModel(image = R.drawable.img_onboarding_screen_second, "Second Screen Title"),
        OnboardingModel(image = R.drawable.img_onboarding_screen_third, "Third Screen Title"),
    )

}