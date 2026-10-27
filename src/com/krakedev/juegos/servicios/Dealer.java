package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.Carta;

public class Dealer {
    private ArrayList<Carta> naipe;

    public Dealer() {
        
        naipe = new ArrayList<Carta>();
      
        generarNaipe();
    }

    public void generarNaipe() {
        String[] palos = {"T", "CN", "CR", "D"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                Carta nuevaCarta = new Carta(valores[j], palos[i]);
                naipe.add(nuevaCarta);
            }
        }
    }

    public void imprimirNaipe() {
        for (Carta carta : naipe) {
            carta.imprimir();
        }
    }

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    public void setNaipe(ArrayList<Carta> naipe) {
        this.naipe = naipe;
    }
}