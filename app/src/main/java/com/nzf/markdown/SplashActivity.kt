package com.nzf.markdown

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import android.widget.TextView


/**
 * Created by niezhuofu on 17-11-8.
 */

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug　　
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */

class SplashActivity : AppCompatActivity() {
    lateinit var tvSplashText: TextView
    lateinit var ivSplashLogo: ImageView
    lateinit var tvSplashName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tvSplashName = findViewById(R.id.tv_splash_name)
        tvSplashText = findViewById(R.id.tv_splash)
        ivSplashLogo = findViewById(R.id.iv_splash_logo)
    }

    override fun onResume() {
        super.onResume()
        startSplashAnimator()
    }

    private fun startSplashAnimator() {
        val alpha = PropertyValuesHolder.ofFloat("alpha", 0.3f, 1f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1f)
        val objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(ivSplashLogo, alpha, scaleX, scaleY)
        val objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(tvSplashText, alpha, scaleX, scaleY)
        val objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(tvSplashName, alpha, scaleX, scaleY)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3)
        animatorSet.interpolator = AccelerateInterpolator()
        animatorSet.duration = 10
        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
        animatorSet.start()
    }

}