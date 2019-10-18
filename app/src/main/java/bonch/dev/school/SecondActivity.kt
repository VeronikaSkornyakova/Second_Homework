package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initializeViews()
        outputOfValues()
    }

    private fun initializeViews(){
        textView = findViewById(R.id.text_output)
    }

    private fun outputOfValues(){

        val indicatorValue = intent.getBooleanExtra("IS_TAPPED", false)
        val counterValue = intent.getIntExtra("TAP_KEY", 0)
        val inputValue = intent.getStringExtra("EDITED_TEXT")

        textView.setText("Was indicator tapped? $indicatorValue" +
                "\nButton in previous activity was tapped $counterValue times" +
                "\n$inputValue")



    }

}