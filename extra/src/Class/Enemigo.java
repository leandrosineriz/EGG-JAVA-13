/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author itsmi
 */
public class Enemigo {
    String nombre;
    double resistencia;
    int x;
    int y;
    int z;
    boolean hostil;

    public Enemigo(String nombre, double resistencia, int x, int y, int z, boolean hostil) {
        this.nombre = nombre;
        this.resistencia = resistencia;
        this.x = x;
        this.y = y;
        this.z = z;
        this.hostil = hostil;
    }

    public Enemigo() {
    }
}
