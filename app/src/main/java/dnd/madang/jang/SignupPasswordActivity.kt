package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_findid.*
import kotlinx.android.synthetic.main.activity_signuppassword.*
import kotlinx.android.synthetic.main.activity_signuppassword.editTextPassWordConfirm

class SignupPasswordActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppassword)
        val intent = Intent(this, SignupNicknameActivity::class.java)

        buttonPasswordSet.setOnClickListener {
            // 비밀번호 일치여부 확인 할 것!
            startActivity(intent)
        }
    }
}