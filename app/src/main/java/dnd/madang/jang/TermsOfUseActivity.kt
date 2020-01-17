package dnd.madang.jang

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_termsofuse.*

class TermsOfUseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termsofuse)
        val intent = Intent(this, SelfCertificationActivity::class.java)
        buttonNext.setAlpha(64)
        checkBox1.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
                buttonNext.setAlpha(255)
            }
            else{
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
                //buttonNext.setColorFilter(R.color.clear)
                buttonNext.setAlpha(64)
            }
        }
        checkBox2.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
                buttonNext.setAlpha(255)
            }
            else{
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
                //buttonNext.setColorFilter(R.color.clear)
                buttonNext.setAlpha(64)
            }
        }
        checkBox3.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
                buttonNext.setAlpha(255)
            }
            else{
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
                //buttonNext.setColorFilter(R.color.clear)
                buttonNext.setAlpha(64)
            }
        }
        checkBox4.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
                buttonNext.setAlpha(255)
            }
            else{
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
                //buttonNext.setColorFilter(R.color.clear)
                buttonNext.setAlpha(64)
            }
        }
        checkBox5.setOnClickListener{
            if(isChecked()){
                textViewNext.setTextColor(Color.parseColor("#ffffff"))
                buttonNext.setAlpha(255)
            }
            else{
                textViewNext.setTextColor(Color.parseColor("#20ffffff"))
                //buttonNext.setColorFilter(R.color.clear)
                buttonNext.setAlpha(64)
            }
        }

        buttonNext.setOnClickListener {
            if (isChecked())
                startActivity(intent)
        }
    }

    private fun isChecked():Boolean {
        if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked){
            return true;
        }
        else {
            return false;
        }
    }
}