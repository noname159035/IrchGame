package com.IrchGame

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.startActivity


class MenuButton : AppCompatButton {
    private var intent: Intent? = null
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?) : super(context!!)

    fun init(intent: Intent){
        this.intent = intent
        setOnClickListener { scaleAnimate(true) }
    }

    private fun scaleAnimate(isFirstAnimation: Boolean) {
        val scaleAnimation: ScaleAnimation = if (isFirstAnimation) ScaleAnimation(
            1f,
            1.1f,
            1f,
            1.1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ) else ScaleAnimation(
            1.1f,
            1f,
            1.1f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.run {
            duration = 50
            setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    if(isFirstAnimation)
                        scaleAnimate(false)
                    else {
                        startActivity(context, intent!!, null)
                    }
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
            startAnimation(this)
        }
    }

}
