package com.bytespectra.onboardingscreensinxml.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.bytespectra.onboardingscreensinxml.R
import com.bytespectra.onboardingscreensinxml.databinding.ActivityMainBinding
import com.bytespectra.onboardingscreensinxml.presentation.adapter.AdapterOnboarding
import com.bytespectra.onboardingscreensinxml.presentation.viewModel.ViewModelOnboarding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val adapter: AdapterOnboarding by lazy { AdapterOnboarding() }
    private val viewModel: ViewModelOnboarding by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViewPager()
        attachTabLayoutWithViewPager()
        initClickListeners()
    }

    private fun attachTabLayoutWithViewPager() {
        binding?.let {
            TabLayoutMediator(it.tabLayout, it.viewPager) { _, _ -> }.attach()
        }
    }

    private fun initViewPager() {
        binding?.viewPager?.adapter = adapter
        adapter.submitList(viewModel.fetchScreensData())
    }

    private fun initClickListeners() {
        binding?.apply {
            ifvSkip.setOnClickListener { onSkipClick() }
            mtvNext.setOnClickListener { onNextClick() }
            mtvGetStarted.setOnClickListener { goToHomeActivity() }
            viewPager.registerOnPageChangeCallback(pageChangeCallback)
        }
    }

    private fun goToHomeActivity() {
        startActivity(Intent(this, ActivityHome::class.java))
        finish()
    }

    private fun onSkipClick() {
        binding?.apply {
            val lastItem = viewPager.adapter?.itemCount?.let { it - 1 } ?: 0
            viewPager.setCurrentItem(lastItem, true)
        }
    }

    private fun onNextClick() {
        binding?.apply {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when (position) {
                2 -> {
                    binding?.apply {
                        mtvGetStarted.visibility = View.VISIBLE
                        mtvNext.visibility = View.GONE
                        ifvSkip.visibility = View.GONE
                        mtvNext.visibility = View.GONE
                    }
                }

                else -> {
                    binding?.apply {
                        mtvNext.visibility = View.VISIBLE
                        mtvGetStarted.visibility = View.GONE
                        ifvSkip.visibility = View.VISIBLE
                        mtvNext.visibility = View.VISIBLE
                    }
                }
            }
            Log.d("PageChange", "Selected page: $position")
        }
    }
}