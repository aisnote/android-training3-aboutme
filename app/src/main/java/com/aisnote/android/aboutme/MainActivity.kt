package com.aisnote.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.aisnote.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName ("Aisnote Liu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

//        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
//            updateNickname(it)
//        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //nicknameTextView.text = editText.text

        //editText.visibility = View.GONE


        //view.visibility = View.GONE

        //binding.nicknameText.text = binding.nicknameEdit.text.toString()

        myName?.nickname = binding.nicknameEdit.text.toString()
        binding.invalidateAll()
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE
        //nicknameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val doneButton = findViewById<Button>(R.id.done_button)

        binding.nicknameEdit.visibility = View.VISIBLE
        //editText.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        //doneButton.visibility = View.VISIBLE
        binding.nicknameText.visibility = View.GONE

        binding.nicknameEdit.requestFocus()
        //editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}
