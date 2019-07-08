package com.learnprogramming.academy.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.learnprogramming.academy.lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     *  Widget Declarations
     */
//    private val _edtView_NickName by lazy { findViewById<EditText>(R.id.edtTxt_Nicname) }
//    private val _txtView_NickName by lazy { findViewById<TextView>(R.id.txtView_Nickname) }
//    private val _btnDone by lazy { findViewById<Button>(R.id.btn_Nickname_Done) }
    private lateinit var _Binding: ActivityMainBinding

    /**
     *  Variable Declarations
     */
    private var _Nickname: String = ""

    private val _ProfileNames:ProfileName = ProfileName("Mehrunes Dagon")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _Binding.profileName = _ProfileNames
        _Binding.btnNicknameDone.setOnClickListener {
            _EnterNickname()
        }

    }

    private fun _EnterNickname() {

        _Nickname = _Binding.edtTxtNicname.text.toString()
        if (_Nickname != "") {
            Toast.makeText(this, "Nickname: $_Nickname Created", Toast.LENGTH_SHORT).show()
            _ProfileNames.NickName = _Binding.edtTxtNicname.text.toString()
            _Binding.apply {
                txtViewNickname?.text = edtTxtNicname.text
                invalidateAll()
                edtTxtNicname.visibility = View.GONE
                btnNicknameDone.visibility = View.GONE
                txtViewNickname.visibility = View.VISIBLE

            }
        }

    }
}
