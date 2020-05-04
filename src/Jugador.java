
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Jugador {
    int bola;
    boolean estado_juego = true;
    public int posInicio,posFin;
    public JLabel  lblJugador;

    public Jugador(int posInicio, int posFin, JLabel lblJugador) {
        this.posInicio = posInicio;
        this.posFin = posFin;
        this.lblJugador = lblJugador;
    }

    public int getPosInicio() {
        return posInicio;
    }

    public void setPosInicio(int posInicio) {
        this.posInicio = posInicio;
    }

    public int getPosFin() {
        return posFin;
    }

    public void setPosFin(int posFin) {
        this.posFin = posFin;
    }
    
      public synchronized void lanzar_tiro(int pelota){
        while(estado_juego == false){
            try {
                wait();
            } catch (InterruptedException e) {
            }
           
            
        }
         estado_juego = false;
            notifyAll();
        
        
        
    }
    public synchronized void apuntar_blanco(){
        while(estado_juego == true){
            try {
                wait();
            } catch (InterruptedException e) {
            }
            
            
        }
        estado_juego=true;
            notifyAll();
            
        }
}
