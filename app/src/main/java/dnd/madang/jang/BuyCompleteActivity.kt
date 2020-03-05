package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_buy_complete.*

class BuyCompleteActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_complete)
        val intent = Intent(this,MainActivity::class.java)
        back_main.setOnClickListener() {
            startActivity(intent)
        }


    }


}