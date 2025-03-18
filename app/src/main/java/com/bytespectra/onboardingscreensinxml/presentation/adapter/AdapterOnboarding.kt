package com.bytespectra.onboardingscreensinxml.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bytespectra.onboardingscreensinxml.databinding.ItemLayoutOnboardingBinding
import com.bytespectra.onboardingscreensinxml.domain.model.OnboardingModel

class AdapterOnboarding: ListAdapter<OnboardingModel, AdapterOnboarding.CustomViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(ItemLayoutOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            ifvImage.setImageResource(currentItem.image)
        }
    }

    inner class CustomViewHolder(val binding: ItemLayoutOnboardingBinding): RecyclerView.ViewHolder(binding.root)
    companion object {
        private val diffUtil = object : ItemCallback<OnboardingModel>() {
            override fun areItemsTheSame(oldItem: OnboardingModel, newItem: OnboardingModel): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(oldItem: OnboardingModel, newItem: OnboardingModel): Boolean {
                return newItem == oldItem
            }
        }
    }
}