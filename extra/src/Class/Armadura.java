/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsmi
 */
public class Armadura {
    String colorPrimario;
    String colorSecundario;
    ArrayList<PiezaArmadura> partesArmadura;
    
    public Armadura() {
    }
    
    public Armadura(String colorPrimario, String colorSecundario, ArrayList<PiezaArmadura> partesArmadura) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.partesArmadura = partesArmadura;
    }

    public double Caminar(double tiempo){
        double suma=0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Bota) {
                this.GestionDanio(p);
                if (!((Bota) p).daniado) {
                    suma += p.UsoBasico(tiempo);
                } else {
                    System.out.println(((Bota) p).nombre+" se encuentra daniado y no se puede utilizar.");
                }
                
            }
        }
        this.CosumoEnergia(suma);
        return suma;
    }
    
    public double Correr(double tiempo){
        double suma=0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Bota) {
                this.GestionDanio(p);
                if (!((Bota) p).daniado) {
                    suma += p.UsoNormal(tiempo);
                } else {
                    System.out.println(((Bota) p).nombre+" se encuentra daniado y no se puede utilizar.");
                }
                
            }
        }
        this.CosumoEnergia(suma);
        return suma;
    }
    
    public double Propulsar(double tiempo){
        double suma=0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Bota) {
                this.GestionDanio(p);
                if (!((Bota) p).daniado) {
                    suma += p.UsoIntensivo(tiempo);
                } else {
                    System.out.println(((Bota) p).nombre+" se encuentra daniado y no se puede utilizar.");
                }
                
            }
        }
        this.CosumoEnergia(suma);
        return suma;
    }
    
    public double Volar(double tiempo){
        double suma=0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Bota) {
                this.GestionDanio(p);
                if (!((Bota) p).daniado) {
                    suma += p.UsoIntensivo(tiempo);
                } else {
                    System.out.println(((Bota) p).nombre+" se encuentra daniado y no se puede utilizar.");
                }
                
            }
        }
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Guante) {
                this.GestionDanio(p);
                if (!((Guante) p).daniado) {
                    suma += p.UsoNormal(tiempo);
                } else {
                    System.out.println(((Guante) p).nombre+" se encuentra daniado y no se puede utilizar.");
                }
                
            }
        }
        this.CosumoEnergia(suma);
        return suma;
    }
    
    public void Escribir(){}
    
    public void Leer(){}
    
    public void Disparar(){}
    
    private double CosumoEnergia(double energia){
        double retorno=0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Pecho) {
                retorno = ((Pecho) p).ReducirEnergia(energia);
            }
        }
        return retorno;
    }
    
    public double EstadoBateriaPorcentaje(){
        double retorno = 0;
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Pecho) {
               retorno = ((Pecho) p).energia*100/((Pecho) p).energiaMax;
            }
        }
        return retorno;
    }
    
    public HashMap getBateriaJoule(){
        HashMap retorno = new HashMap();
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Pecho) {
                retorno.put("max", ((Pecho) p).energiaMax);
                retorno.put("actual", ((Pecho) p).energia);
            }
        }
        return retorno;
    }
    
    public HashMap getBateriaErgio(){
        HashMap retorno = new HashMap();
        for (PiezaArmadura p : partesArmadura) {
            if (p instanceof Pecho) {
               retorno.put("max", ((Pecho) p).energiaMax*1*Math.pow(10,7));
               retorno.put("actual", ((Pecho) p).energia*1*Math.pow(10,7));
            }
        }
        return retorno;
    }
    
    public void GestionDanio(PiezaArmadura p){
        boolean continuar = true;
        if (!p.daniado) {
            if (this.SeDania(p)) {
                System.out.println("Se ha daniado "+p.nombre);
            }
        } else {
            if (!p.destruido) {
                while (continuar) {    
                    System.out.println("");
                    System.out.println("Iniciando protocolo para reparacion de "+p.nombre+"...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Armadura.class.getName()).log(Level.SEVERE, "Error delay", ex);
                    }
                    if (this.SeRepara(p)) {
                        System.out.println("Reparacion exitosa.");
                        continuar = false;
                    } else {
                        System.out.println("No se pudo reparar.");
                        if (this.SeDestruye(p)) {
                            System.out.println("La pieza de armadura "+p.nombre+" se a destruido.");
                            continuar = false;
                        }
                    }
                }
            } else {
                System.out.println("La pieza de armadura "+p.nombre+" se encuentra destruida.");
            }
        }
    }
    
    public boolean SeDania(PiezaArmadura p){
        if ((int) (Math.random() * 100)<=30) {
            p.daniado = true;
        }
        return p.daniado;
    }
    
    public boolean SeRepara(PiezaArmadura p){
        if ((int) (Math.random() * 100)<=40) {
            p.daniado = false;
        }
        return !p.daniado;
    }
    
    public boolean SeDestruye(PiezaArmadura p){
        if ((int) (Math.random() * 100)<=30) {
            p.destruido = true;
        }
        return p.destruido;
    }
}