package com.polettiapps.lucaspoletti.math.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.polettiapps.lucaspoletti.math.R;

import java.text.DecimalFormat;

public class CalculadoraRaizesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_numeroRaiz;
    Button b_calcularRaiz;
    TextView tv_raizes, tv_raizArredondada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_raizes);

        et_numeroRaiz = (EditText) findViewById(R.id.editText_numeroRaiz);
        b_calcularRaiz = (Button) findViewById(R.id.button_calcularRaizes);
        tv_raizes = (TextView) findViewById(R.id.textView_respostaRaizes);
        tv_raizArredondada = (TextView) findViewById((R.id.textView_respostaRaizesArredondada));

        b_calcularRaiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(et_numeroRaiz.getText().length() == 0) {

            Toast.makeText(this, "Todos os campos possuem preenchimento obrigatório", Toast.LENGTH_LONG).show();

        } else {

            double numeroRaiz = Double.parseDouble(et_numeroRaiz.getText().toString());
            double resultado = Math.sqrt(numeroRaiz);

            tv_raizes.setText("Resultado: " + resultado);

            if(tv_raizes.getText().length() > 15) {

                DecimalFormat formato = new DecimalFormat("#.##");
                resultado = Double.valueOf(formato.format(resultado));
                tv_raizArredondada.setText("Valor arredondado: " + resultado);

            }

        }

    }
}
