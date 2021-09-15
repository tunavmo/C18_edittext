package com.vmodev.c18_edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_deactivated.setOnClickListener {
            et_default.isEnabled = !et_default.isEnabled
        }

        et_default.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                et_default.background = getDrawable(R.drawable.focus_et)
//                Toast.makeText(this, "Focused", Toast.LENGTH_LONG).show()
                et_default.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        if (et_default.text.length >=6) {
                            et_default.background = getDrawable(R.drawable.success_et)
                        } else if (et_default.text.length > 0) {
                            et_default.background = getDrawable(R.drawable.error_et)
                        } else {
                            et_default.background = getDrawable(R.drawable.focus_et)
                        }
                    }
                    override fun afterTextChanged(s: Editable?) {
                    }
                })
            } else {
                //hasText
                if (et_default.text.toString().equals("")) {
                    et_default.background = getDrawable(R.drawable.default_et)
                }
                //!hasText
                else if (!et_default.text.toString().equals(""))
                    et_default.background = getDrawable(R.drawable.filled_et)
//                Toast.makeText(this, "UnFocused", Toast.LENGTH_LONG).show()
            }
        }
    }
}