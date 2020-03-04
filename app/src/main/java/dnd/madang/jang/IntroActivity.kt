package dnd.madang.jang

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
        setContentView(R.layout.activity_intro)
        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorWhite)
        val anim = AnimationUtils.loadAnimation(applicationContext,R.anim.fadein)
        logo.startAnimation(anim)


        val intent = Intent(this,LoginActivity::class.java)
        switch_activity(intent)

    }

    private fun switch_activity(intent: Intent) {
        val handler = Handler()

        val millisTime = 1000
        val handlerTask = object : Runnable {
            override fun run() {
                startActivity(intent)
            }
        }

        handler.postDelayed(handlerTask, 1500)
    }

}
