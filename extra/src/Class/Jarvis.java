/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import extra.Extra;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsmi
 */
public class Jarvis {
    ArrayList<Enemigo> enemigos;
    Armadura armadura;
    
    public void Start(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Casco casco = new Casco(100, 100, 100, 1, 100, false, false, "Casco");
        Pecho pecho = new Pecho(100, 1, 100, false, false, "Pecho");
        Guante guante1 = new Guante(100, 1, 100, false, false, "Guante Izquierdo");
        Guante guante2 = new Guante(100, 1, 100, false, false, "Guante Derecho");
        Bota bota1 = new Bota(100, 1, 100, false, false, "Bota Izquierda");
        Bota bota2 = new Bota(100, 1, 100, false, false, "Bota Derecha");
        ArrayList<PiezaArmadura> p = new ArrayList();
        p.add(casco);
        p.add(pecho);
        p.add(guante1);
        p.add(guante2);
        p.add(bota1);
        p.add(bota2);
        armadura = new Armadura("Rojo", "Dorado", p);
        try {
            // TODO code application logic here
            System.out.println("Activando Jarvis...");
            Thread.sleep(1000);
            System.out.println("Bienvenido Tony.");
            Thread.sleep(1000);
            
            while (true) {     
                System.out.println("\n********************************"
                        + "\nIndique su proxima orden:\n"
                        + "1. Caminar\n"
                        + "2. Correr\n"
                        + "3. Propulsarse\n"
                        + "4. Volar\n"
                        + "8. Mostrar estado\n");
                this.MostrarBateriaPorcentaje();
                this.MostrarBateriaJoule();
                this.MostrarBateriaErgio();

                int var = leer.nextInt();

                switch (var) {
                    case 1:
                        System.out.println("Cuanto tiempo desea caminar?:");
                        int tiempo = leer.nextInt();
                        System.out.println("Caminando...");
                        Thread.sleep(1000);
                        System.out.println("Se consumio "+armadura.Caminar(tiempo)+" de energia caminando.");
                        Thread.sleep(1000);
                        break;
                    case 2:
                        System.out.println("Cuanto tiempo desea Correr?:");
                        tiempo = leer.nextInt();
                        System.out.println("Corriendo...");
                        Thread.sleep(1000);
                        System.out.println("Se consumio "+armadura.Correr(tiempo)+" de energia corriendo.");
                        Thread.sleep(1000);
                        break;
                    case 3:
                        System.out.println("Cuanto tiempo desea Propulsarse?:");
                        tiempo = leer.nextInt();
                        System.out.println("Propulsandose...");
                        Thread.sleep(1000);
                        System.out.println("Se consumio "+armadura.Propulsar(tiempo)+" de energia propulsandose.");
                        Thread.sleep(1000);
                        break;
                    case 4:
                        System.out.println("Cuanto tiempo desea Volar?:");
                        tiempo = leer.nextInt();
                        System.out.println("Activando procolo de vuelo...");
                        Thread.sleep(500);
                        System.out.println("Volando...");
                        Thread.sleep(1000);
                        System.out.println("Se consumio "+armadura.Volar(tiempo)+" de energia volando.");
                        Thread.sleep(1000);
                        break;
                    case 8:
                        this.MostrarEstadoAll();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Extra.class.getName()).log(Level.SEVERE, "Error de delay", ex);
        }
    }
    
    public void MostrarEstadoAll(){
        for (PiezaArmadura p : armadura.partesArmadura) {
            System.out.println(p);
        }
    }
    
    public void MostrarBateriaPorcentaje(){
        System.out.println("Bateria reactor: "+armadura.EstadoBateriaPorcentaje()+"%");
    }
    
    public void MostrarBateriaJoule(){
        System.out.println("Bateria reactor: "+armadura.getBateriaJoule().get("actual")+"/"+armadura.getBateriaJoule().get("max")
                +" Joules");
    }
    
    public void MostrarBateriaErgio(){
        System.out.println("Bateria reactor: "+armadura.getBateriaErgio().get("actual")+"/"+armadura.getBateriaErgio().get("max")
                +" Ergios");
    }
    
    public void RevisarDispositivos(){}
    
    public void UsarRadar(){}
    
    public void AtacarEnemigos(){}
    
    public void AccionesEvasivas(){}
}
