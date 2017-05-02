package com.senac.br.core.main;

import com.senac.br.core.configuration.IslandFinder;
import com.senac.br.core.entity.MatrixCustom;
import com.senac.br.core.utils.MatrixUtils;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String file = "/home/pvmeira/IdeaProjects/ProjetoAlgoritimosIII/resources/example_3.txt";
        MatrixUtils m = new MatrixUtils();
        IslandFinder i = new IslandFinder();

        try {
            MatrixCustom matrix = m.loadFromFile(file);
            MatrixCustom matrixCustom = new MatrixCustom(matrix.getLines(), matrix.getColumns());
            m.printTo(System.out, matrix);
            System.out.print("Total de ilhas : " + i.countIslands(matrix.getData(), matrixCustom.getData()));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot load file: " + args[0]);
        }

//        char[][] matrix1 = m.createMatrixFromTxt(file);
//        char[][] matrix2 = new char[matrix1.length][matrix1[0].length];
//        matrix2 = m.createNewMatrixFill0(matrix2);
//
//        int [][] meh = m.transformMatrixCharInt(matrix1);
//        int [][] meh1 =m.transformMatrixCharInt(matrix2);
//
//        m.printIntMatrix("sssss",meh);

    }
}
