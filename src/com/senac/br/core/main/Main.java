package com.senac.br.core.main;

import com.senac.br.core.configuration.MatrixUtils;

public class Main {

    public static void main(String[] args) {
	String file = "/home/pvmeira/IdeaProjects/ProjetoAlgoritimosIII/resources/example_1.txt";
        MatrixUtils m = new MatrixUtils();

        m.printMatrix("meh",m.createMatrixFromTxt(file));

    }
}
