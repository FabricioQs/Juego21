package com.krakedev.juegos.entidades;

import java.util.ArrayList;

	public class Jugador {
    private String nickName;
   
    private ArrayList<Carta> cartas = new ArrayList<>();
    
    private int puntajeCartas;

    public Jugador(String nickName) {
        this.nickName = nickName;
    }

    public void recibirCarta(Carta carta) {
        cartas.add(carta);
    }

    public void imprimir() {
        System.out.println("Jugador: " + nickName);
        for (Carta carta : cartas) {
            carta.imprimir();
        }
    }

   
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    public int getPuntajeCartas() {
        return puntajeCartas;
    }

    public void setPuntajeCartas(int puntajeCartas) {
        this.puntajeCartas = puntajeCartas;
    }
}