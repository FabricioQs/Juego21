package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        int maximo = 10;
        
        System.out.println("Generando 100 números aleatorios entre 0 y " + maximo + ":");
        for (int i = 0; i < 100; i++) {
            int numero = dealer.generarAleatorio(maximo);
            System.out.print(numero + " ");
            
           
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}