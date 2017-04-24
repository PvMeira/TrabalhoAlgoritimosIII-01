package com.senac.br.core.main;

import com.senac.br.core.utils.MatrixUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String file = "/home/pvmeira/IdeaProjects/ProjetoAlgoritimosIII/resources/example_1.txt";
        MatrixUtils m = new MatrixUtils();
        char[][] meh = m.createMatrixFromTxt(file);
        char[][] meh11221 = m.createMatrixFromTxt(file);
        m.printMatrix("meh", meh);
        m.printMatrix("meh2", m.createNewMatrixFill0(meh11221));

    }
}
