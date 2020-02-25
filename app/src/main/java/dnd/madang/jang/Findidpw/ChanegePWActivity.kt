package dnd.madang.jang.Findidpw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.LoginActivity
import dnd.madang.jang.R
import kotlinx.android.synthetic.main.activity_chanegepw.*

class ChanegePWActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chanegepw)

        var homeintent=Intent(this,LoginActivity::class.java)
        checkpw_btn.setOnClickListener(){
            startActivity(homeintent)

        }
    }
}