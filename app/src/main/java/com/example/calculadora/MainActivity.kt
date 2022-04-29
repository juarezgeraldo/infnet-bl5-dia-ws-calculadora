package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {
    private lateinit var txtTotalConta: EditText
    private lateinit var txtPessoas: EditText
    private lateinit var skGorgeta: SeekBar
    private var formatador = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotalConta = this.findViewById(R.id.txtTotalConta)
        txtTotalConta.setOnFocusChangeListener(this)

        txtPessoas = this.findViewById(R.id.txtPessoas)
        txtPessoas.setOnFocusChangeListener(this)

        skGorgeta = this.findViewById(R.id.skGorgeta)
        skGorgeta.setOnFocusChangeListener(this)

    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}