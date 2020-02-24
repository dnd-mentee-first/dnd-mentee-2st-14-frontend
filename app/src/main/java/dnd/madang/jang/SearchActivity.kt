package dnd.madang.jang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activty_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_search)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_blank, SearchFragment())
            .commit()

        button_frag1.setOnClickListener() {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_blank, SearchFragment())
                .commit()

        }

        button_frag2.setOnClickListener() {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_blank, CategoryFragment())
                .commit()

        }


    }
}




