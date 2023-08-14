package com.example.kotlin_di2hiltexample.step4

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kotlin_di2hiltexample.R
import com.example.kotlin_di2hiltexample.databinding.ActivityStep4Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityStep4 : AppCompatActivity() {

    @Inject
    lateinit var wiFiManager: WiFiManager

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityStep4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MyLog", "ActivityStep4 instance id: $wiFiManager")
        binding = ActivityStep4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_activity_step4)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_activity_step4)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}