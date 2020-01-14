package dnd.madang.jang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_findidpw.*

class FindidpwActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findidpw)

        findid_btn.setOnClickListener {
        supportFragmentManager.beginTransaction()
        .replace(R.id.findidpwlay, FindidpwFragment())
        .commit()
    }
    }
}


