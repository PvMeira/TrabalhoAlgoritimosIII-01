package com.senac.br.core.main;

import com.senac.br.core.utils.MatrixUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String file = "/home/pvmeira/IdeaProjects/ProjetoAlgoritimosIII/resources/example_1.txt";
        MatrixUtils m = new MatrixUtils();
        char[][] mmmmm = m.createMatrixFromTxt(file);
        char[][] a22 = m.createMatrixFromTxt(file);
        m.printMatrix("meh", mmmmm);
        m.printMatrix("meh2", m.createNewMatrixFill0(a22));

    }
}
