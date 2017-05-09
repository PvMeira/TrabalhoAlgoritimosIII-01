package com.senac.br.core.main;

import com.senac.br.core.configuration.IslandFinder;
import com.senac.br.core.entity.MatrixCustom;
import com.senac.br.core.utils.MatrixUtils;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        //Write Here the location of the file that needs to be read
    	String separator = System.getProperty("file.separator");
        String file = "resources"+separator+"example_3.txt";

        MatrixUtils m = new MatrixUtils();
        IslandFinder i = new IslandFinder();

        try {
            MatrixCustom matrix = m.loadFromFile(file);
            MatrixCustom matrixCustom = new MatrixCustom(matrix.getLines(), matrix.getColumns());
            m.printTo(System.out, matrix);
            System.out.print("Total de ilhas : " + i.countIslands(matrix.getData(), matrixCustom.getData()) +"\n");

            //Comment this part if you dont need the postions of the matrix present on the file
            System.out.println("########Posições##########");
           i.getPositionIsland(matrix.getData());

        } catch (FileNotFoundException e) {
            System.err.println("Cannot load file: " + args[0]);
        }



    }
}
