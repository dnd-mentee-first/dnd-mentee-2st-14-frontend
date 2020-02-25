package dnd.madang.jang.Findidpw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.R
import kotlinx.android.synthetic.main.activity_findigt.*

class FindigtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findigt)

        supportFragmentManager.beginTransaction()
            .replace(R.id.findigtlay, FindidFragment())
            .commit()

        var intent = Intent(this,ChanegePWActivity::class.java)
        phonenumcheck_btn.setOnClickListener(){
          startActivity(intent)
        }
    }
}