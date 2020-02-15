package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signupnickname.*
import kotlinx.android.synthetic.main.activity_signuppassword.*

class SignupNicknameActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupnickname)

        val intent = Intent(this, SignupAddressActivity::class.java)
        buttonNickname.setOnClickListener {
            // 1. 닉네임 중복 검사 할 것
            // 2. 한번 더 확인 후 인텐트 전환

            // 다음 인텐트로 넘어가기
            intent.putExtra("nickname", fieldPassword.text.toString())
            startActivity(intent)
        }
    }
}