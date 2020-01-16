package dnd.madang.jang

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_selfcertification.*

class SelfCertificationActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selfcertification)
        val intent = Intent(this, SignupPasswordActivity::class.java)

        getNumButton.setOnClickListener {
            showHide(checkNumberTextView)
            showHide(checkNumberButton)
            showHide(checkNumberText)
        }
        getPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher()) // -(dash)문자 자동 입력

        checkNumberButton.setOnClickListener {
            startActivity(intent)

        }
    }

    private fun showHide(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.INVISIBLE
        } else{
            View.VISIBLE
        }
    }
}