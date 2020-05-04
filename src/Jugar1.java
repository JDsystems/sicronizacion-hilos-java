
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Jugar1 extends Thread {

    Thread j = new Thread(this);
    Jugador jugador;
    int pelota, mov_jugador, total_puntos;
    ArrayList<Integer> datos = new ArrayList<>();

    public Jugar1(Jugador jugador, int pelota) {
        this.jugador = jugador;
        this.pelota = pelota;
    }

    public void numero_aleatorio() {
        int dinamico = (int) (Math.random() * 4) + 1;
        if (dinamico == 1) {
            Principal.label_jug.setLocation(600, 0);
            mov_jugador = 40;
            datos.add(8);
        } else if (dinamico == 2) {
            Principal.label_jug.setLocation(600, 70);
            mov_jugador = 120;
            datos.add(8);
        } else if (dinamico == 3) {
            Principal.label_jug.setLocation(600, 170);
            mov_jugador = 220;
            datos.add(7);
        } else if (dinamico == 4) {
            Principal.label_jug.setLocation(600, 260);
            mov_jugador = 310;
            datos.add(3);

        }
    }

    public void run() {
        int i = 1;
        do {
            jugador.apuntar_blanco();
            numero_aleatorio();
            jugador.setPosInicio(540);
            jugador.lblJugador.setLocation(jugador.getPosInicio(), mov_jugador);
            if (i == 10) {
                j.stop();
            }
            i++;
        } while (i <= 10);
        for (int k = 0; k < datos.size(); k++) {
            Principal.area_datos.append("TIRO " + (k + 1) + " ** " + datos.get(k) + " PUNTOS\n");
            total_puntos += datos.get(k);

        }
        Principal.area_datos.append("\n");
        Principal.area_datos.append("TOTAL PUNTOS: " + total_puntos);
        Principal.area_datos.setVisible(true);
        Principal.jScrollPane1.setVisible(true);
    }

}
