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

public class CalculadoraIMCActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_peso, et_altura;
    Button b_calcular;
    TextView tv_respostaNumero, tv_respostaEscrita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        et_peso = (EditText) findViewById(R.id.editText_peso);
        et_altura = (EditText) findViewById(R.id.editText_altura);
        b_calcular = (Button) findViewById(R.id.button_calcularIMC);
        tv_respostaNumero = (TextView) findViewById(R.id.textView_respostaIMC1);
        tv_respostaEscrita = (TextView) findViewById(R.id.textView_respostaIMC2);

        b_calcular.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        DecimalFormat formato = new DecimalFormat("#.##");

        if(et_peso.getText().length() == 0 || et_altura.getText().length() == 0) {

            Toast.makeText(this, "Todos os campos possuem preenchimento obrigatório", Toast.LENGTH_LONG).show();

        } else if(et_peso != null && et_altura != null) {

            double peso = Double.parseDouble(et_peso.getText().toString());
            double altura = Double.parseDouble(et_altura.getText().toString());

            double resposta = peso / (altura * altura);

            resposta = Double.valueOf(formato.format(resposta));
            tv_respostaNumero.setText("Resposta: " + resposta);

            if(resposta < 17 ) {

                tv_respostaEscrita.setText("Você está muito abaixo do peso ideal");

            } else if (resposta >= 17 && resposta <= 18.49 ) {

                tv_respostaEscrita.setText("Você está abaixo do peso ideal");

            } else if (resposta >= 18.5 && resposta <= 24.99) {

                tv_respostaEscrita.setText("Você está no peso ideal");

            } else if (resposta >= 25 && resposta <= 29.99) {

                tv_respostaEscrita.setText("Você está acima do peso ideal");

            } else if (resposta >= 30 && resposta <= 34.99) {

                tv_respostaEscrita.setText("Você está no nível de Obesidade I");

            } else if (resposta >= 35 && resposta <= 39.99) {

                tv_respostaEscrita.setText("Você está no nível de Obesidade II (Severa)");

            } else if (resposta >= 40) {

                tv_respostaEscrita.setText("Você está no nível de Obesidade III (Mórbida)");

            }

        }




    }
}
