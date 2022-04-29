package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener, SeekBar.OnSeekBarChangeListener {
    private lateinit var txtTotalConta: EditText
    private lateinit var txtPessoas: EditText
    private lateinit var skGorjeta: SeekBar
    private var formatador = NumberFormat.getCurrencyInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotalConta = this.findViewById(R.id.txtTotalConta)
        txtTotalConta.setOnFocusChangeListener(this)

        txtPessoas = this.findViewById(R.id.txtPessoas)
        txtPessoas.setOnFocusChangeListener(this)

        skGorjeta = this.findViewById(R.id.skGorjeta)
        skGorjeta.setOnSeekBarChangeListener(this)

    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        this.atualizaDadosConta()
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val lblPercentualGorjeta = this.findViewById<TextView>(R.id.lblPercentualGorjeta)
//        lblPercentualGorjeta.setText(skGorjeta.progress.toString() + "%")
        lblPercentualGorjeta.setText(p1.toString() + "%")
        this.atualizaDadosConta()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    private fun atualizaDadosConta(){
        if (txtTotalConta.text.toString().isNotEmpty() && txtPessoas.text.toString().isNotEmpty()){
            val valorConta = txtTotalConta.text.toString().toDouble()
            val qtdPessoas = txtPessoas.text.toString().toInt()

            val lblValorGorjeta = this.findViewById<TextView>(R.id.lblValorGorjeta)
            val valorGorjeta = valorConta * skGorjeta.progress / 100
            lblValorGorjeta.setText(formatador.format((valorGorjeta)))

            val lblValorTotal = this.findViewById<TextView>(R.id.lblValorTotal)
            lblValorTotal.setText(formatador.format(valorConta + valorGorjeta))

            val lblValorPessoa = this.findViewById<TextView>(R.id.lblValorPessoa)
            lblValorPessoa.setText(formatador.format((valorConta + valorGorjeta) / qtdPessoas))


        }
    }
}