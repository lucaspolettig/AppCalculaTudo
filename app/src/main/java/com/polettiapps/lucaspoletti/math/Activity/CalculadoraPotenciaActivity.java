package com.polettiapps.lucaspoletti.math.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.polettiapps.lucaspoletti.math.R;

import org.w3c.dom.Text;

public class CalculadoraPotenciaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_numeroReal, et_numeroElevado;
    Button button_calcular;
    TextView tv_respostaPotencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_potencia);

        et_numeroReal = (EditText) findViewById(R.id.editText_valor);
        et_numeroElevado = (EditText) findViewById(R.id.editText_elevado);
        button_calcular = (Button) findViewById(R.id.button_calcularPotencias);
        tv_respostaPotencia = (TextView) findViewById(R.id.textView_respostaPotencia);

        button_calcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        double numeroReal = Double.parseDouble(et_numeroReal.getText().toString());
        int numeroElevado = Integer.parseInt(et_numeroElevado.getText().toString());
        double resultado = 0.00;

        if(et_numeroReal.getText().length() == 0) {

            Toast.makeText(this, "Todos os campos possuem preenchimento obrigatório", Toast.LENGTH_LONG).show();

        } else if(numeroElevado == 0){

            tv_respostaPotencia.setText("Resultado: Qualquer número elevado ao expoente 0 possui o resultado 1");

        } else if(numeroElevado == 1) {

            tv_respostaPotencia.setText("Resultado: " + numeroReal);

        } else if (et_numeroReal != null || et_numeroElevado != null && numeroElevado > 0) {

            resultado = numeroReal;

            for (int i = 1; i < numeroElevado; i++) {
                resultado = resultado * numeroReal;
            }

            tv_respostaPotencia.setText("Resultado: " + resultado);
        }

    }
}
