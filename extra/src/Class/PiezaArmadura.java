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
public class PiezaArmadura {
    double resistencia;
    double consumo;
    double salud;
    boolean daniado;
    boolean destruido;
    String nombre;

    public PiezaArmadura() {
    }

    public PiezaArmadura(double resistencia, double consumo, double salud, boolean daniado, boolean destruido, String nombre) {
        this.resistencia = resistencia;
        this.consumo = consumo;
        this.salud = salud;
        this.daniado = daniado;
        this.destruido = destruido;
        this.nombre = nombre;
    }
    
    double UsoBasico(double tiempo){
        return this.consumo*1*tiempo;
    }
    
    double UsoNormal(double tiempo){
        return this.consumo*2*tiempo;
    }
    
    double UsoIntensivo(double tiempo){
        return this.consumo*3*tiempo;
    }
    
    boolean Reparar(){
        return false;
    }

    @Override
    public String toString() {
        return "resistencia=" + resistencia + ", consumo=" + consumo + ", salud=" + salud + ", daniado=" + daniado + 
                ", destruido=" + destruido + ", nombre=" + nombre;
    }
    
}
