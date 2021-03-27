/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gavilan.dlc.desafio01.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {

    @Override
    public List<Integer> read() {
        List<Integer> conjunto = new ArrayList();
        File file = new File("list[100000].txt");
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                int num = scanner.nextInt();
                conjunto.add(num);
            }
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        }
        
        return conjunto;
    }
}
