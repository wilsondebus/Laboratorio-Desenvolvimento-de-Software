/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1;

/**
 *
 * @author wilsi
 */
public class ContaCorrente {
    
    public float getSaldo() {
        return saldo;
    }
    
    private float saldo; 
    
    public void definirSaldoInicial(float valor){
        saldo = valor; 
    }
    
    public void depositar(float valor){
        saldo += valor; 
    }
    
    public boolean sacar(float valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        } else{
            return false; 
        }
    }
}

