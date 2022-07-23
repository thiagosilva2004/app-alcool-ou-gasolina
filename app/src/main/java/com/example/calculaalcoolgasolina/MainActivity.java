package com.example.calculaalcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.txtAlcool);
        editPrecoGasolina = findViewById(R.id.txtGasolina);
        textResultado = findViewById(R.id.labelResultado);

    }

    public void calcularPreco(View view){
        try {

            if(editPrecoAlcool.getText().toString() == ""){
                textResultado.setText("campo alcool deve ser preenchido");
                return;
            }

            if(editPrecoGasolina.getText().toString() == ""){
                textResultado.setText("campo gasolina deve ser preenchidos");
                return;
            }

            Double precoAlcool = Double.parseDouble(editPrecoAlcool.getText().toString());
            Double precoGasolina = Double.parseDouble(editPrecoGasolina.getText().toString());

            Double resultado = precoAlcool / precoGasolina;

            if(resultado >= 0.7){
                textResultado.setText("melhor utilizar a gasolina");
            }else{
                textResultado.setText("Melhor utilizar o alcool");
            }

        }
        catch (Exception e){
            textResultado.setText("erro: " + e.toString());
        }
    }
}