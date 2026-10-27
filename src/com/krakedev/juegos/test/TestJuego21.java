package com.krakedev.juegos.test;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {
    public static void main(String[] args) {
        Juego21 juego = new Juego21();
        
        juego.agregarJugador(new Jugador("Fabricio"));
        juego.agregarJugador(new Jugador("David"));
        juego.agregarJugador(new Jugador("Kenner"));
        
        System.out.println("--- INICIANDO SIMULACIÓN DE 10 JUEGOS ---");
        
        // Ejecutar varias veces hasta que existan ganadores
        for (int i = 1; i <= 10; i++) {
            System.out.println("\n--- JUEGO " + i + " ---");
            
            // Encerar puntajes, quitar cartas y armar nuevo mazo
            juego.reiniciarJuego(); 
            
            // Ejecutar jugar()
            ArrayList<Jugador> ganadores = juego.jugar();
            
            if (ganadores.size() > 0) {
                System.out.println("¡TENEMOS GANADOR(ES) EN EL JUEGO " + i + "!");
                for (Jugador ganador : ganadores) {
                    System.out.println("Ganador: " + ganador.getNickName() + " con " + ganador.getPuntajeCartas() + " puntos.");
                }
                break; // Si queremos detener la simulación al encontrar un ganador
            } else {
                System.out.println("Nadie llegó a 21 puntos. Resultados finales:");
                // Validar que se asignaron cartas e imprimirlas
                for (Jugador jugador : juego.getJugadores()) { // Necesitas generar getJugadores() en Juego21 si no lo tienes
                    jugador.imprimir();
                    System.out.println("Puntaje total: " + jugador.getPuntajeCartas());
                }
            }
        }
    }
}