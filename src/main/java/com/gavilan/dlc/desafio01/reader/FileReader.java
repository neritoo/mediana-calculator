package com.gavilan.dlc.desafio01.reader;

import java.util.List;

/**
 * Clase que lee archivo de txt para mapearlos a un List.
 * @author eze_g
 */
public interface FileReader {
    
    /**
     * Lee un archivo txt y crea un List con los números de dentro.
     * @return listado con numeros en un List.
     */
    List<Integer> read();
}
