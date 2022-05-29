package com.chiller3.slidergone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.isVisible
import com.chiller3.slidergone.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.toggleVisibility.setOnClickListener {
            binding.slider.isVisible = !binding.slider.isVisible
        }

        binding.callEnsureLabelsRemoved.setOnClickListener {
            val ensureLabelsRemoved = binding.slider.javaClass.superclass
                .getDeclaredMethod("ensureLabelsRemoved")
            ensureLabelsRemoved.isAccessible = true
            ensureLabelsRemoved.invoke(binding.slider)
        }
    }
}