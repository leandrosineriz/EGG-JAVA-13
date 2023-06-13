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
public class Pecho extends PiezaArmadura {
    double energia;
    double energiaMax;

    public Pecho() {
    }

    public Pecho(double resistencia, double consumo, double salud, boolean daniado, boolean destruido, String nombre) {
        super(resistencia, consumo, salud, daniado, destruido, nombre);
        //this.energia = Float.MAX_VALUE;
        //this.energiaMax = Float.MAX_VALUE;
        this.energia = 10000;
        this.energiaMax = 10000;
    }
    
    public double ReducirEnergia(double e){
        this.energia-=e;
        return this.energia;
    }

    @Override
    public String toString() {
        return super.toString() + " energia=" + energia;
    }
    
    
}
