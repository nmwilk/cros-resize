package com.tophatch.resizeable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val showSurfaceView = intent.getBooleanExtra("surfaceView", false)

        val layoutResID = if (showSurfaceView) R.layout.activity_main_surface else R.layout.activity_main
        setContentView(layoutResID)

        val showOverlay = intent.getBooleanExtra("overlay", false)
        if (showOverlay) {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = PerformanceHackDialogFragment()
            transaction.addToBackStack(fragment::class.java.simpleName)
            transaction.add(fragment, fragment::class.java.simpleName)
            transaction.commit()
        }

        title = when {
            showOverlay -> "Use Overlay"
            showSurfaceView -> "Use Overlay & SurfaceView"
            else -> "No Overlay"
        }
    }
}
