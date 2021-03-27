package com.gavilan.dlc.desafio01.mediana;

import com.gavilan.dlc.desafio01.utils.TSBHeap;
import java.util.List;

/**
 * Implementación de {@link MedianaCalculator} utilizando TSBHeap.
 *
 * @author eze_g
 */
public class MedianaHeapCalculator implements MedianaCalculator {

    private TSBHeap<Integer> h0;
    private TSBHeap<Integer> h1;

    public MedianaHeapCalculator() {
        h0 = new TSBHeap(true);
        h1 = new TSBHeap(false);
    }

    @Override
    public double calcularMediana(List<Integer> conjunto, int totalAProcesar) {
        double mediana = 0.0;

        int k = totalAProcesar;

        for (int i = 0; i < k; i++) {

            // Llenamos por primera vez ambos heaps
            if (h0.isEmpty()) {
                h0.add(conjunto.get(i));
                mediana = obtenerMediana(conjunto, i);
                continue;
            } else if (h1.isEmpty()) {
                // El nuevo num es menor que cima h0 ? se agrega : se cambia
                if (conjunto.get(i) < h0.get()) {
                    h1.add(conjunto.get(i));
                } else {
                    // intercambiar
                    int temp = h0.remove();
                    h1.add(temp);
                    h0.add(conjunto.get(i));
                }
                mediana = obtenerMediana(conjunto, i);
                continue;
            }

            // Llenados los primeros lugares de los heaps, validando siempre
            // que h0.get() > h1.get() procedemos.
            
            // Siempre asegurarse de insertar el nuevo numero en h1 si es menor
            // a h0.get().
            if (conjunto.get(i) < h0.get()) {
                // si no se puede insertar otro numero en h1, se intercambian
                // con h0.
                // si se puede insertar en h1, se inserta directo.
                if (existeDiffh1()) {
                    int temp = h1.remove();
                    h0.add(temp);
                    h1.add(conjunto.get(i));
                } else h1.add(conjunto.get(i));
            } else {
                // si no se puede insertar otro numero en h0, se intercambian con
                // h1.
                // si se puede insertar en h0, se inserta directo.
                if (existeDiffh2()) {
                    int temp = h0.remove();
                    h1.add(temp);
                    h0.add(conjunto.get(i));
                } else h0.add(conjunto.get(i));
            }

            mediana = obtenerMediana(conjunto, i);

        }
        
        return mediana;
    }

    /**
     * Asegura que el espacio de h1 no supera el limite de diferencia 1.
     * @return boolean.
     */
    private boolean existeDiffh1() {
        return (h1.size() - h0.size()) + 1 > 1;
    }
    
    /**
     * Asegura que el espacio de h0 no supera el limite de diferencia 1.
     * @return boolean.
     */
    private boolean existeDiffh2() {
        return (h0.size() - h1.size() + 1 > 1);
    }

    /**
     * Obtiene la mediana a partir de un conjunto de numeros, y los heaps que
     * pertenecen a la clase calculadora.
     *
     * @param conjunto listado de numeros.
     * @param i posición actual del conjunto.
     * @return mediana parcial.
     */
    private double obtenerMediana(List<Integer> conjunto, int i) {
        double mediana = 0.0;
        
        if ((h0.size() + h1.size()) % 2 == 0) {
            int suma = h0.get() + h1.get();
            mediana = (double) suma / 2;
        }
        
        if (h0.size() > h1.size()) {
            mediana = h0.get();
        } else if (h1.size() > h0.size()) {
            mediana = h1.get();
        }

        return mediana;
    }
}
