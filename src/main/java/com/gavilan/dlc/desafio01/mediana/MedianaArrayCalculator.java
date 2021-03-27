package com.gavilan.dlc.desafio01.mediana;

import java.util.List;

/**
 * Clase que se encarga de calcular la mediana, con ayuda de TSBHeap.
 * @author eze_g
 */
public class MedianaArrayCalculator implements MedianaCalculator {
    
    @Override
    public double calcularMediana(List<Integer> conjunto, int totalAProcesar) {
        double mediana = 0.0;
        
        int[] aux = new int[totalAProcesar];
        
        // Cargamos array auxiliar con los datos de los numeros enteros
        for(int i= 0; i < totalAProcesar; i++) {
            aux[i] = conjunto.get(i);
        }
        
        bubbleSort(aux);
        
        mediana = auxCalculo(aux);
        
        return mediana;
    }
    
    private double auxCalculo(int[] v) {
        double med;
        int size = v.length;
        if(v.length % 2 == 0) {
            int sumMedios = v[size/2] + v[size/2 - 1];
            med = (double) sumMedios / 2;
        } else med = v[size/2];
        
        return med;
    }
    
    private void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i=0; i < array.length - 1; i++) {
                if(array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
