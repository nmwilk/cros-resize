package com.tophatch.resizeable

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_chooser.*

class ChooserActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)

        useOverlayButton.setOnClickListener(this)
        noOverlayButton.setOnClickListener(this)
        noOverlaySurfaceViewButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        startActivity(Intent(this, MainActivity::class.java).apply {
            putExtra("overlay", v.id == R.id.useOverlayButton)
            putExtra("surfaceView", v.id == R.id.noOverlaySurfaceViewButton)
        })
    }
}
