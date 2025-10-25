package aplicacion;

import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {     
        
        boolean salir = false;
       
        do{
            switch(menu()){
                case 1: metodo1();
                        break;
                case 2: metodo2();
                        break;
                case 3: metodo3();
                        break;
                case 0: System.out.println("gracias por utilizar la aplicación");
                		salir = true;
                        break;
            }
        }while(!salir);   
    }
   
    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 3;

        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Opción 1.");
            System.out.println("2. Opción 2.");
            System.out.println("3. Opción 3.");
            System.out.println("0. Salir de la aplicación.\n");
            opcion = entrada.nextByte();
            if(opcion < MINIMO || opcion > MAXIMO){
                System.out.println("Escull una opció vàlida");
            }
        }while(opcion < MINIMO || opcion > MAXIMO);
        return opcion;
    }
   
    public static void metodo1(){
        System.out.println("Metodo 1");
    }
   
    public static void metodo2(){
       System.out.println("Metodo 2");
    }
   
    public static void metodo3(){
       System.out.println("Metodo 3");
    }
}
