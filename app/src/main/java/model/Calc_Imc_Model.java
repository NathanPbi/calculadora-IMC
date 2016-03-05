package model;

/**
 * Created by jonatas on 31/10/2015.
 */
public class Calc_Imc_Model {

    private double imc;

    public double calcularIMC(double peso, double altura){
        this.imc = peso / Math.pow(altura, 2);
        return this.imc;
    }

    public double getImc() {
        return imc;
    }

    public String mensagemAoUsuario(){

        if(this.imc < 17){
            return "Você está muito abaixo do Peso";
        } else if(this.imc >= 17 && imc <= 18.49){
            return "Você está abaixo do Peso";
        } else if(this.imc >= 18.5 && imc <= 24.99){
            return "Você está com o Peso normal";
        } else if(this.imc >= 25 && imc <= 29.99){
            return "Você está acima do Peso";
        } else if(this.imc >= 30 && imc <= 34.99){
            return "Você está com nível 1 de Obesidade";
        } else if(this.imc >= 35 && imc <= 39.99){
            return "Você está com obesidade Severa";
        } else if(this.imc >= 40){
            return "Você está com obesidade Mórbida";
        }
        return null;
    }









}
