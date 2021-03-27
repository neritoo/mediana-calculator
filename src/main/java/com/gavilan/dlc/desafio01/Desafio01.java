package com.gavilan.dlc.desafio01;

import com.gavilan.dlc.desafio01.reader.FileReaderImpl;
import com.gavilan.dlc.desafio01.mediana.MedianaArrayCalculator;
import com.gavilan.dlc.desafio01.mediana.MedianaCalculator;
import com.gavilan.dlc.desafio01.mediana.MedianaHeapCalculator;
import com.gavilan.dlc.desafio01.mediana.constants.ConjuntoPrueba;
import com.gavilan.dlc.desafio01.utils.TSBHeap;
import java.util.Scanner;
import com.gavilan.dlc.desafio01.reader.FileReader;
import java.util.List;

/**
 *
 * @author eze_g
 */
public class Desafio01 {
    public static void main(String[] args) {
        MedianaCalculator medianaCalculator;
        FileReader reader = new FileReaderImpl();
        List<Integer> conjunto;
        
       Scanner scanner = new Scanner(System.in);
       int cantProcesar;
       double mediana;
       int opcionMenu;
       do {
           System.out.println("##################");
           System.out.println("Seleccione algoritmo a utilizar");
           System.out.println("1. Array");
           System.out.println("2. Heaps");
           System.out.println("0. Salir");
           System.out.println("Opción: ");
           opcionMenu = scanner.nextInt();
           switch(opcionMenu) {
               case 1:
                   System.out.println("Seleccione cantidad de elementos a calcular mediana: ");
                   cantProcesar = scanner.nextInt();
                   
                   conjunto = reader.read();
                   
                   if (cantProcesar > conjunto.size()) {
                       System.out.println("Cantidad a procesar supera el total del conjunto");
                       break;
                   }
                   
                   medianaCalculator = new MedianaArrayCalculator();
                   mediana = medianaCalculator.calcularMediana(conjunto, cantProcesar);
                   System.out.println("Mediana: " + mediana);
                   break;
               case 2:
                   System.out.println("Seleccione cantidad de elementos a calcular mediana: ");
                   cantProcesar = scanner.nextInt();
                   // Obtener el conjunto a procsar.
                   conjunto = reader.read();
                   
                   // Validar que la cant a procesar no sea mayor al size del conjunto.
                   if (cantProcesar > conjunto.size()) {
                       System.out.println("Cantidad a procesar supera el total del conjunto");
                       break;
                   }
                   
                   medianaCalculator = new MedianaHeapCalculator();
                   mediana = medianaCalculator.calcularMediana(conjunto, cantProcesar);
                   System.out.println("Mediana: " + mediana);
                   break;
               case 0: ;
           }
       }
       while (opcionMenu != 0);
    }
}
