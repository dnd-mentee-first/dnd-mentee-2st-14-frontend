package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signuppassword.*
import kotlinx.android.synthetic.main.activity_signuppassword.fieldPasswordConfirm

class SignupPasswordActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppassword)
        val nextIntent = Intent(this, SignupNicknameActivity::class.java)
        buttonPasswordSet.setOnClickListener {
            // 비밀번호 일치여부 확인 할 것!
            println(fieldPassword.text.toString())
            println(fieldPasswordConfirm.text.toString())
            if(fieldPassword.text.toString()==fieldPasswordConfirm.text.toString()) {
                // Kotlin에서 ==연산자는 문자열 비교할 때 사용
                nextIntent.putExtra("password", fieldPassword.text.toString())
                nextIntent.putExtra("id", intent.getStringExtra("id"))
                println("작동")
                startActivity(nextIntent)
            }
        }
    }
}