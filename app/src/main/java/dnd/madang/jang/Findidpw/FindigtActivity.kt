package dnd.madang.jang.Findidpw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.R

class FindigtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findigt)

        supportFragmentManager.beginTransaction()
            .replace(R.id.findigtlay, FindidFragment())
            .commit()
        /* phonenumcheck_btn.setOnClickListener(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.findigtlay, ChanegePWFragment())
                .commit()
        }*/
}
}