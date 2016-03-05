package com.example.jonatas.calculadoraimc;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import controller.Calc_Imc_Controller;
import model.Calc_Imc_Model;

public class CalculadoraImc extends AppCompatActivity {



    private EditText peso;
    private EditText altura;
    private Button btnCalcular;
    private LinearLayout linear;
    private TextView tvResultado;
    private Button btnVoltar;

    // variáveis do controller e model
    Calc_Imc_Controller calController;
    Calc_Imc_Model calModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);


            altura = (EditText) findViewById(R.id.edtAltura);
            peso = (EditText) findViewById(R.id.edtPeso);
            btnCalcular = (Button) findViewById(R.id.btnCalcular);
            linear = (LinearLayout) findViewById(R.id.linearLayout);
            tvResultado = (TextView) findViewById(R.id.tvResultado);
            btnVoltar = (Button) findViewById(R.id.btnVoltarAoNormal);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora_imc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void calcularIMC(View view){
        //valida se a altura e o peso não estão nulos(vazios) para assim poder realizar os calculos
        if(!this.altura.getText().toString().isEmpty() && !this.peso.getText().toString().isEmpty()) {

            //faz o cast da altura e do peso para se tornarem Double
            double altura = Double.parseDouble(this.altura.getText().toString());
            double peso = Double.parseDouble(this.peso.getText().toString());

            //instancia o controller para realizar a chamada aos seu métodos
            this.calController = new Calc_Imc_Controller();

            //aciona o controller para ele acionar o model para realizar o calculo do imc, o mesmo retorna um double imc
            double imc = this.calController.calcularIMC(peso, altura);

            //responsável por fazer com que o imc só seja mostrado com duas casas decimais
            imc = Double.valueOf(String.format(Locale.US, "%.2f", imc));

            //aciona o controller para ele acionar o model para realizar a verificação de cada tipo de imc, o mesmo retorna uma string
            String msg = this.calController.mensagemAoUsuario();


            linear.setVisibility(View.GONE);

            tvResultado.setText(msg);
            tvResultado.setVisibility(View.VISIBLE);

            view.setVisibility(View.GONE);

            btnVoltar.setVisibility(View.VISIBLE);

            //instancia o objeto responsável por mostrar o resultado do IMC e a mensagem que será exibida ao usuário
            /*AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Seu IMC é: " + imc);
            alertDialog.setMessage(msg);
            alertDialog.show();*/

        //caso não tenha sido preenchido a altura ou peso o aplicativo não deixa realizar o calculo (validação)
        }else {
            Toast.makeText(CalculadoraImc.this, "Você precisa preencher todos os campos!", Toast.LENGTH_LONG).show();
        }
    }

    public void voltar(View view){
        view.setVisibility(View.INVISIBLE);

        btnCalcular.setVisibility(View.VISIBLE);

        tvResultado.setVisibility(View.INVISIBLE);

        linear.setVisibility(View.VISIBLE);

        altura.setText("");
        peso.setText("");
    }

}
