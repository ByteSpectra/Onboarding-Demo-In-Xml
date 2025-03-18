package com.bytespectra.onboardingscreensinxml.domain.model

import androidx.annotation.DrawableRes

data class OnboardingModel(
    @DrawableRes val image: Int,
    val text: String
)
