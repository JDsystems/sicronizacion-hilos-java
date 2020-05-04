/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Jugar2 extends Thread{
    Jugador jugador;
    int pelota,bola,posInicial;
    Thread j = new Thread(this);
    
    public Jugar2(Jugador j, int pel){
        this.jugador = j;
        this.pelota = pel;
        this.bola = pel;
        posInicial = jugador.posInicio;
    }
    
    
    public void run(){
        try {
            int i = 1;
            while(i <= 10){
                jugador.lanzar_tiro(i); 
                do {              
                    jugador.lblJugador.setLocation(jugador.posInicio, jugador.lblJugador.getY()); 
                    j.sleep(2);
                    jugador.posInicio -= 1;
                    
                } while (jugador.posFin <= jugador.posInicio); 
                if (i == 10) {
                    
                    j.stop();
                }
                i++;
            }
        } catch (Exception e) {
        }
    }
}
