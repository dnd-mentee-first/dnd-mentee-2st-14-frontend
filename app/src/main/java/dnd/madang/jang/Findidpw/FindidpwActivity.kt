package dnd.madang.jang.Findidpw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.R
import kotlinx.android.synthetic.main.activity_findidpw.*

class FindidpwActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findidpw)

        supportFragmentManager.beginTransaction()
            .replace(R.id.findidpwlay, FindidFragment())
            .commit()

        findid_btn.setOnClickListener {
        supportFragmentManager.beginTransaction()
        .replace(R.id.findidpwlay, FindidFragment())
        .commit()

        }
        findpw_btn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.findidpwlay, FindpwFragment())
                .commit()
        }
    }

}


