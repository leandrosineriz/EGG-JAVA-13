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
public class Casco extends PiezaArmadura {
    double consola;
    double sintetizador;

    public Casco(double consola, double sintetizador, double resistencia, double consumo, double salud, boolean daniado, boolean destruido, String nombre) {
        super(resistencia, consumo, salud, daniado, destruido, nombre);
        this.consola = consola;
        this.sintetizador = sintetizador;
    }

    public Casco() {
    }

    @Override
    public String toString() {
        return super.toString() + " consola=" + consola + ", sintetizador=" + sintetizador;
    }
    
    
}
