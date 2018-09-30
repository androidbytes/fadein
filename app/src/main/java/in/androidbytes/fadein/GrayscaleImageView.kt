package `in`.androidbytes.fadein

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.util.AttributeSet
import android.widget.ImageView

class GrayscaleImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs), ValueAnimator.AnimatorUpdateListener  {

    private val colorMatrix = ColorMatrix()

    private val duration = 2000L
    private val valueAnimator = ValueAnimator.ofFloat(0f, 1f)
    private val onAnimation = object : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator) {}
        override fun onAnimationCancel(p0: Animator) {}

        override fun onAnimationStart(p0: Animator) {
            setHasTransientState(true)
        }

        override fun onAnimationEnd(p0: Animator) {
            setHasTransientState(false)
        }
    }

    init {
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener(this)
        valueAnimator.addListener(onAnimation)
    }

    private fun desaturate() {
        colorMatrix.setSaturation(0f)
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    public fun saturate() {
        desaturate()
        valueAnimator.start()
    }

    override fun onAnimationUpdate(animator: ValueAnimator) {
        val animatedValue = animator.animatedValue as Float
        colorMatrix.setSaturation(animatedValue)
        colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}