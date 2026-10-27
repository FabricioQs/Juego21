package com.krakedev.juegos.servicios;

import java.util.ArrayList;
import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
    private ArrayList<Jugador> jugadores;
    private Dealer dealer;

    public Juego21() {
        jugadores = new ArrayList<>();
    }

    public void inicializar() {
        dealer = new Dealer();
        cargarValores();
    }

    public void cargarValores() {
        ArrayList<Carta> naipe = dealer.getNaipe();
        
        for (Carta carta : naipe) {
            String valor = carta.getValor();
            
            if (valor.equals("A")) {
                carta.setValorJuego(11);
            } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                carta.setValorJuego(10);
            } else {
             
                int valorNumerico = Integer.parseInt(valor);
                carta.setValorJuego(valorNumerico);
            }
        }
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void repartirCarta(Jugador jugador) {
        Carta cartaEntregada = dealer.entregarCarta();
        jugador.recibirCarta(cartaEntregada);
    }

    public void repartirRonda() {
        for (Jugador jugador : jugadores) {
            repartirCarta(jugador);
        }
        calcularTotal(); 
    }
    
    public void calcularTotal() {
        for (Jugador jugador : jugadores) {
            int total = 0;
            for (Carta carta : jugador.getCartas()) {
                total += carta.getValorJuego();
            }
            jugador.setPuntajeCartas(total); 
        }
    }
    
   
    public Dealer getDealer() {
        return dealer;
    }
    
 // 
    public ArrayList<Jugador> validarGanador() {
        ArrayList<Jugador> ganadores = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntajeCartas() == 21) {
                ganadores.add(jugador);
            }
        }
        return ganadores;
    }

    
    public ArrayList<Jugador> jugar() {
        ArrayList<Jugador> ganadores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            repartirRonda();
            ganadores = validarGanador();
            if (ganadores.size() > 0) { 
                break;
            }
        }
        return ganadores;
    }

    
    public void reiniciarJuego() {
        for (Jugador jugador : jugadores) {
            jugador.getCartas().clear(); 
            jugador.setPuntajeCartas(0); 
        }
        inicializar(); 
    }
    
 
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}