/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author itsmi
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int x = (int) (Math.random() * 500);
        boolean running = true;
        while (running) {  
            System.out.println("Ingrese un numero entre 1 - 500(x: "+x+"):");
            try {
                int j = leer.nextInt();
                if (j<1 || j>500) {
                    throw new IllegalStateException("Rango incorrecto.");
                }
                if (x == j) {
                    System.out.println("Ganaste");
                    running = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor incorrecto. Ingrese un numero valido:");
                leer.next();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Valor incorrecto. Ingrese un numero valido:");
                leer.next();
            }finally {
                
            }
            
        }
            
    }
}
   

