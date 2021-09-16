package com.example.conversormoedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.math.RoundingMode

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var button_converter: Button? = null
    private var text_view_resultado: TextView? = null
    private var radio_button_dolar:RadioButton? = null
    private var radio_button_euro:RadioButton? = null
    private var edit_text_valor:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        setClicksEvents()
    }


    private fun initComponents(){
        button_converter = findViewById(R.id.button_converter)
        text_view_resultado = findViewById(R.id.text_view_resultado)
        radio_button_dolar = findViewById(R.id.radio_button_dolar)
        radio_button_euro = findViewById(R.id.radio_button_euro)
        edit_text_valor = findViewById(R.id.edit_text_valor)
    }

    private fun setClicksEvents(){
        button_converter?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        var valorConvertido:Double? = null
        var valor:String? = null


        when(id){
            R.id.button_converter -> {
                if((edit_text_valor?.text?.trim()?.length!! <=0) == true){
                    edit_text_valor?.setError("Informe um valor")
                    text_view_resultado?.visibility = View.GONE
                }else{
                    if(radio_button_dolar?.isChecked == true){
                        valor  = edit_text_valor?.text.toString()
                        valorConvertido =  ( valor.toDouble() / 5.25 ).toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
                        text_view_resultado?.text = "Valor convertido em Dólar: ${valorConvertido}$"
                    }
                    if(radio_button_euro?.isChecked == true){
                        valor  = edit_text_valor?.text.toString()
                        valorConvertido =   (valor.toDouble() / 6.17).toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
                        text_view_resultado?.text = "Valor convertido em Euro: ${valorConvertido}€ "
                    }
                    text_view_resultado?.visibility = View.VISIBLE
                }
            }
        }
    }
}