package dnd.madang.jang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val intent = Intent(this,MainActivity::class.java)
        switch_activity(intent)

    }

    fun switch_activity(intent: Intent) {
        val handler = Handler()

        val millisTime = 1000
        val handlerTask = object : Runnable {
            override fun run() {
                // task 발생

                startActivity(intent)
            }
        }

        handler.postDelayed(handlerTask, 1500)
    }

}
