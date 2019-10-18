package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import bonch.dev.school.models.Counter
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity() : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button

    private lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initializeViews()

        if (savedInstanceState == null)
            counter = Counter() else {
            val key = "TAP_AMOUNTS"
            counter = Counter(savedInstanceState.getInt(key))
            indicatorButton.isEnabled = savedInstanceState.getBoolean("WAS_TAPPED")
        }

        counterButton.text = "${counter.currentCounter} taps"

        setListeners()
    }



    private fun initializeViews() {

        indicatorButton = findViewById(R.id.indicator_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)


    }

    private fun setListeners() {

        val intent = Intent (this@FirstActivity, SecondActivity::class.java)

        counterButton.setOnClickListener(View.OnClickListener {
            counter.increment()
            counterButton.text = "${counter.currentCounter} taps"
        })

        nextActivityButton.setOnClickListener(View.OnClickListener {
            intent.putExtra("EDITED_TEXT", textField.text.toString())
            intent.putExtra("TAP_KEY", counter.currentCounter)
            intent.putExtra ("IS_TAPPED", !(indicatorButton.isEnabled))
            startActivity(intent)
        })

        indicatorButton.setOnClickListener(View.OnClickListener {
            indicatorButton.isEnabled = false
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCounter)
        outState.putBoolean("WAS_TAPPED", indicatorButton.isEnabled)
    }
}