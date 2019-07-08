package com.learnprogramming.academy.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     *  Widget Declarations
     */
    private val _edtView_NickName by lazy {findViewById<EditText>(R.id.edtTxt_Nicname)}
    private val _txtView_NickName by lazy {findViewById<TextView>(R.id.txtView_Nickname)}
    private val _btnDone by lazy {findViewById<Button>(R.id.btn_Nickname_Done)}

    /**
     *  Variable Declarations
     */
    private var _Nickname:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _btnDone.setOnClickListener {
            _EnterNickname()
        }

    }

    private fun _EnterNickname() {
        _Nickname = _edtView_NickName?.text.toString()
        if(_Nickname!="")
        {
            Toast.makeText(this,"Nickname: $_Nickname Created",Toast.LENGTH_SHORT).show()
            _edtView_NickName.visibility = View.GONE
            _btnDone.visibility = View.GONE
            _txtView_NickName.visibility = TextView.VISIBLE
            _txtView_NickName.text = _Nickname
        }
    }
}
