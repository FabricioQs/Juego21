package com.krakedev.juegos.test;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {
    public static void main(String[] args) {
        Juego21 juego = new Juego21();
        
      
        Jugador j1 = new Jugador("Fabricio");
        Jugador j2 = new Jugador("David");
        Jugador j3 = new Jugador("Kenner");
        
        juego.agregarJugador(j1);
        juego.agregarJugador(j2);
        juego.agregarJugador(j3);
        
       
        juego.inicializar();
        
       
        System.out.println("--- REPARTIENDO RONDA ---");
        juego.repartirRonda();
        
       
        j1.imprimir();
        j2.imprimir();
        j3.imprimir();
        
      
        System.out.println("\n--- CARTAS RESTANTES EN EL NAIPE ---");
        juego.getDealer().imprimirNaipe();
    }
}