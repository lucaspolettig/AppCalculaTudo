package com.polettiapps.lucaspoletti.math.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.polettiapps.lucaspoletti.math.R;

public class CalculadoraRegraDeTresSimplesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_se, et_equivale, et_entao, et_x;
    Button button_calcular;
    TextView tv_resposta;
    Double se, equivale, entao, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_regra_de_tres_simples);

        et_se = (EditText) findViewById(R.id.editText_Se);
        et_equivale = (EditText) findViewById(R.id.editText_equivaleA);
        et_entao = (EditText) findViewById(R.id.editText_entao);
        et_x = (EditText) findViewById(R.id.editText_x);

        tv_resposta = (TextView) findViewById(R.id.textView_resposta);

        button_calcular = (Button) findViewById(R.id.button_calcular);
        button_calcular.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(et_se.getText().length() == 0 || et_equivale.getText().length() == 0 || et_entao.getText().length() == 0) {

            Toast.makeText(this, "Todos os campos possuem preenchimento obrigatório", Toast.LENGTH_LONG).show();

        } else {
            se = Double.parseDouble(et_se.getText().toString());
            equivale = Double.parseDouble(et_equivale.getText().toString());
            entao = Double.parseDouble(et_entao.getText().toString());
            //x = Double.parseDouble(et_x.getText().toString());
            Log.d("Variavel se", se + "");
            Log.d("Variavel equiva", equivale + "");
            Log.d("Variavel entao", entao + "");

            double calculo1 = entao * equivale;
            Log.d("Calculo 1", calculo1 + "");
            double resultado = calculo1 / se;
            Log.d("resultado", resultado + "");
            tv_resposta.setText("" + resultado);

        }
    }
}
