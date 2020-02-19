package dnd.madang.jang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_selfcertification.*
import org.json.JSONObject
import java.net.URL

class SignupAddressActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupaddress)
        // 1. 주소를 처리하는 API작성 후 수정할 것
        // 2. Post방식으로 회원가입 처리하기
        val result: String = PostTask().execute("http://api.madangiron.kro.kr/register", intent.getStringExtra("id"),
                intent.getStringExtra("password"),
                intent.getStringExtra("nickname"), // TODO: 이름을 수집하는 Activity가 없음
                intent.getStringExtra("nickname")).get()
        val res = JSONObject(result)
        val resultObject = res.getJSONObject("result")
        val isRegister = resultObject.getString("isRegister")
        println("RES결과 : \n" + res)
        println("\nisRegister결과: " + isRegister)
//        println("인텐트 가져오기: " + intent.getStringExtra("id") + intent.getStringExtra("password") +
//                intent.getStringExtra("nickname") + intent.getStringExtra("nickname"))
    }
}