package dnd.madang.jang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dnd.madang.jang.Findidpw.FindidpwActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // 레이아웃 파일이랑 연결하는 코드
        val intent = Intent(this,TermsOfUseActivity::class.java)
        val intent2 = Intent(this, FindidpwActivity::class.java)
        val intent3 = Intent(this,MainActivity::class.java)
        newguestbtn.setOnClickListener{
            startActivity(intent)

        }
        WrongIDPWbtn.setOnClickListener{
            startActivity(intent2)
        }
        login_btn.setOnClickListener{
            startActivity(intent3)
        }
    }
}
//
//sign up test