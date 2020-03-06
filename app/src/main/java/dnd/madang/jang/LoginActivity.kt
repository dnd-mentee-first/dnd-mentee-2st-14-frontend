package dnd.madang.jang

import android.accounts.Account
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dnd.madang.jang.Findidpw.FindigtActivity
import kotlinx.android.synthetic.main.activity_login.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activty_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // 레이아웃 파일이랑 연결하는 코드
        val intent = Intent(this,TermsOfUseActivity::class.java)
        val intent2 = Intent(this, FindigtActivity::class.java)
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorWhite)


        newguestbtn.setOnClickListener{
            startActivity(intent)

        }

        WrongIDPWbtn.setOnClickListener{
            startActivity(intent2)

        }

        login_btn.setOnClickListener{
            receiveDatasfromAPI(this,ID.getText().toString(),PW.getText().toString())

        }
    }

    private fun receiveDatasfromAPI(context : Context, user_id : String,user_pw : String){

        Log.d("Response::","Clicked receive")
        val retrofit = Retrofit.Builder().baseUrl("http://api.madangiron.kro.kr/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val retrofit_service =  retrofit.create(RetrofitService::class.java)
        Log.d("CheckID","ID$user_id,PW$user_pw")
        retrofit_service.loginAccount(LoginVO(user_id,user_pw)).enqueue(object : Callback<AccountBaseResponse> {

            override fun onFailure(call : Call<AccountBaseResponse>?, t: Throwable?) {
                Log.d("Response::","No Repsonse")
                Log.d("Response::","Log${t.toString()}")
            }
            override fun onResponse(call : Call<AccountBaseResponse>?, response : Response<AccountBaseResponse>) {
                Log.d("Response:::r",response.body()?.result?.isLoggedin.toString())

                var isLoggedIn : String = response.body()?.result?.isLoggedin.toString()
                if(isLoggedIn == "true") {
                    val intent3 = Intent(context, MainActivity::class.java)
                    startActivity(intent3)
                }
                }

        })


    }


}
//
//sign up test