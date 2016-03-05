package controller;

import android.widget.EditText;

import model.Calc_Imc_Model;

/**
 * Created by jonatas on 31/10/2015.
 */
public class Calc_Imc_Controller {

    //variavel model
    Calc_Imc_Model calc_model = new Calc_Imc_Model();;



    public double calcularIMC(double peso, double altura){

        double imc = this.calc_model.calcularIMC(peso, altura);

        return imc;

    }

    public String mensagemAoUsuario(){
        return this.calc_model.mensagemAoUsuario();
    }




}
