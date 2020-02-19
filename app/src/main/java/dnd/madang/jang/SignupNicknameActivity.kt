package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_selfcertification.*
import kotlinx.android.synthetic.main.activity_signupnickname.*
import kotlinx.android.synthetic.main.activity_signuppassword.*
import org.json.JSONObject

class SignupNicknameActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupnickname)

        val nextIntent = Intent(this, SignupAddressActivity::class.java)
        buttonNickname.setOnClickListener {
            // 1. 닉네임 중복 검사 할 것
            val result: String = APITask().execute("http://api.madangiron.kro.kr/users/nickname/" + fieldNickname.text.toString()).get()
            val res = JSONObject(result)
            val resultObject = res.getJSONObject("result")
            val checkNickname = resultObject.getString("nickname_check")
            println("nickname_check: " + checkNickname)
            // 다음 인텐트로 넘어가기
            if(checkNickname.toBoolean()){
                // 2. 한번 더 확인 후 인텐트 전환
                println("승인된 닉네임: " + fieldNickname.text.toString())
                nextIntent.putExtra("id",intent.getStringExtra("id"))
                nextIntent.putExtra("password",intent.getStringExtra("password"))
                nextIntent.putExtra("nickname", fieldNickname.text.toString())
                startActivity(nextIntent)
            }
            else{
                Toast.makeText(this,"이미 존재하는 닉네임입니다. 다른 닉네임을 사용해 주세요.",Toast.LENGTH_LONG)
            }
        }
    }
}