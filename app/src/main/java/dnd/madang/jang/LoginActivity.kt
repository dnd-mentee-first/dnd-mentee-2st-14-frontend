package dnd.madang.jang

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.Findidpw.FindigtActivity
import kotlinx.android.synthetic.main.activity_login.*
import androidx.core.content.ContextCompat



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // 레이아웃 파일이랑 연결하는 코드
        val intent = Intent(this,TermsOfUseActivity::class.java)
        val intent2 = Intent(this, FindigtActivity::class.java)
        val intent3 = Intent(this,MainActivity::class.java)
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorWhite)


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