package dnd.madang.jang

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,SearchActivity::class.java)
        intent.putExtra("how","buy")
        val intent2 = Intent(this,SearchActivity::class.java)
        intent2.putExtra("how","sell")
        imageButton2.setOnClickListener() {
            startActivity(intent)
        }
        sell_btn.setOnClickListener() {
            startActivity(intent2)
        }
    }


}
//sign up test
