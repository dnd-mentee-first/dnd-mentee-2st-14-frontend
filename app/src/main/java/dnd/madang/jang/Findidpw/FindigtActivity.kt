package dnd.madang.jang.Findidpw

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.R

class FindigtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_findigt)

        supportFragmentManager.beginTransaction()
            .replace(R.id.findidpwlay, FindidFragment())
            .commit()
    }
}