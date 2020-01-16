package dnd.madang.jang

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_termsofuse.*

class TermsOfUseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termsofuse)
        val intent = Intent(this, SelfCertificationActivity::class.java)
        //val intent = Intent(this, SelfCertificationActivity::class.java)
        checkBox1.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
            }
            else
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
        }

        nextButton.setOnClickListener {
            if (isChecked())
                startActivity(intent)
        }
    }

    private fun isChecked():Boolean{
        if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked){
            return true;
        }
        else {
            return false;
        }
    }
}