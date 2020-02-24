package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_selfcertification.*
import kotlinx.android.synthetic.main.activity_signupaddress.*
import org.json.JSONObject
import java.net.URL

class SignupAddressActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupaddress)
        buttonNext.setOnClickListener(this)
        // TODO: 1. 주소를 처리하는 API작성 후 수정할 것


        // 2. Post방식으로 회원가입 처리하기
    }

    override fun onClick(view: View) {
        var nextIntent = Intent(this, LoginActivity::class.java)
        when (view.id) {
            R.id.buttonNext -> {
                val result: String = PostTask().execute("http://api.madangiron.kro.kr/register", intent.getStringExtra("id"),
                    intent.getStringExtra("password"),
                    intent.getStringExtra("nickname"), // TODO: 이름을 수집하는 Activity가 없음
                    intent.getStringExtra("nickname")).get()
                val res = JSONObject(result)
                val resultObject = res.getJSONObject("result")
                val isRegister = resultObject.getString("isRegister")
                println("RES결과 : \n" + res)
                println("\nisRegister결과: " + isRegister)
                if(isRegister.toBoolean()){
                    val nextIntent = Intent(this,LoginActivity::class.java)
                    startActivity(nextIntent)
                }
                else{
                    Toast.makeText(this, "회원가입 절차에 문제가 생겼습니다. 처음부터 다시 시도해 주세요.",Toast.LENGTH_LONG)
                    val nextIntent = Intent(this,TermsOfUseActivity::class.java)
                    startActivity(nextIntent)
                }
            }
        }
    }
}