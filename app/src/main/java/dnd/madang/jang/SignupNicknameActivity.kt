package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signupnickname.*

class SignupNicknameActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupnickname)

        val intent = Intent(this, SignupAddressActivity::class.java)
        buttonNickname.setOnClickListener {
            startActivity(intent)
        }
    }
}