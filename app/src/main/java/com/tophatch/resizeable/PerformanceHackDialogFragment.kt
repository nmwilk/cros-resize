package com.tophatch.resizeable

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment

class PerformanceHackDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, 0)
        isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View(context)
        view.setBackgroundColor(0x00000000)

        val window = dialog?.window
        val params = window!!.attributes
        params.gravity = Gravity.START or Gravity.TOP
        params.x = 0
        params.y = 0
        params.flags = params.flags or (WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        window.attributes = params

        return view
    }

    override fun onStart() {
        super.onStart()
        val window = dialog?.window
        window!!.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        val attributes = window.attributes
        attributes.width = 1
        attributes.height = 1
        window.attributes = attributes
    }
}
