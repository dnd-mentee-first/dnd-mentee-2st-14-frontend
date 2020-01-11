package dnd.madang.jang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_termsofuse.*

class TermsOfUseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termsofuse)
        val intent = Intent(this, SelfCertificationActivity::class.java)
        //val intent = Intent(this, SelfCertificationActivity::class.java)

        nextButton.setOnClickListener {
            if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked && checkBox4.isChecked && checkBox5.isChecked)
                startActivity(intent)
        }
    }
}