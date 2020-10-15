package com.developer.ditmar.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView inputlabel;
    String cad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cad = "";
        loadComponets();
        /*String cad = "cos2";
        Calculadora calc = new Calculadora(cad);
        String result = calc.solve();
        Log.d("RESULT=>", result);*/
    }

    private void loadComponets() {
        inputlabel = findViewById(R.id.maininput);
        Button runbtn = findViewById(R.id.resultfinal);
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cad = "";
                inputlabel.setText("");
            }
        });
        runbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculadora calc = new Calculadora(cad);
                String result = calc.solve();
                inputlabel.setText(result);
            }
        });
        Integer[] lista = {
                R.id.button0, R.id.button1,
                R.id.button2, R.id.button3,
                R.id.button4, R.id.button5,
                R.id.button6, R.id.button7,
                R.id.button8, R.id.button9,
                R.id.button10,R.id.button11,
                R.id.button13,
                R.id.button14,R.id.button15,
                R.id.button19, R.id.button20,
                R.id.button21,  R.id.buttoncos,
                R.id.buttonsin,R.id.buttontan,
                R.id.buttonlog,R.id.buttonln,
                R.id.buttonexp,R.id.buttonsqrt,

        };
        for (int i = 0; i < lista.length; i++) {
            Button btn = findViewById(lista[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button)view;
        cad += btn.getText();
        inputlabel.setText(cad);
    }
}
