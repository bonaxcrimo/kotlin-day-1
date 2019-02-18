package com.bonzdev.kotlindaysone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTranslationY = tvNumber.translationY
        sbNumber.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               tvNumber.text = progress.toString()
                val translationDistance = (initialTextViewTranslationY + progress + resources.getDimension(R.dimen.text_anim_step) * -1)
                tvNumber.animate().translationY(translationDistance)
                if(!fromUser)
                    tvNumber.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        btnReset.setOnClickListener { v ->
            sbNumber.progress = 0
        }
    }
}
