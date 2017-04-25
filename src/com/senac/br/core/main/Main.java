package com.senac.br.core.main;

import com.senac.br.core.configuration.IslandFinder;
import com.senac.br.core.utils.MatrixUtils;

public class Main {

    public static void main(String[] args) {
        String file = "/home/pvmeira/IdeaProjects/ProjetoAlgoritimosIII/resources/example_4.txt";
        MatrixUtils m = new MatrixUtils();
        IslandFinder i = new IslandFinder();

        char[][] matrix1 = m.createMatrixFromTxt(file);
        char[][] matrix2 = new char[matrix1.length][matrix1[0].length];
        matrix2 = m.createNewMatrixFill0(matrix2);

        int [][] meh = m.transformMatrixCharInt(matrix1);
        int [][] meh1 =m.transformMatrixCharInt(matrix2);

        m.printIntMatrix("sssss",meh);
        System.out.print("Total de ilhas : "+ i.countIslands(meh,meh1));
//        char[][] a22 = m.createMatrixFromTxt(file);
//        m.printMatrix("meh", matrix1);
//        m.printMatrix("meh2", m.createNewMatrixFill0(a22));

    }
}
