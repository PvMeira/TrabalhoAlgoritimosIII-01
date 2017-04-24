package com.senac.br.core.configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

/**
 * Created by pvmeira on 24/04/17.
 */
public class MatrixUtils {

    private static List<Integer> columList = new ArrayList();
    private static String ERROR_NOTFOUND = "Não encontrou o arquivo!";
    private static String ERROR_CANNOT_FOUND = "Não conseguiu ler o arquivo!";
    private static String ERROR_PARSE = "Erro de parse";
    public MatrixUtils() {
    }

    public char[][] createMatrixFromTxt(String path) {
        int columCount= 0;
        int lineCount = 0;
        char[][] fileMatrix = new char[lineCount][columCount];

            try {

                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    String[] colin = reader.readLine().split(" ");
                    int columQuantity = Integer.parseInt(colin[0]);
                    columList.add(columQuantity);
                    int lineQuantity = Integer.parseInt(colin[1]);
                    fileMatrix = new char[lineQuantity][columQuantity];

                    for (int i = 0; i < fileMatrix.length; ++i) {
                        String line = reader.readLine();

                        for (int j = 0; j < columQuantity; ++j) {
                            fileMatrix[i][j] = line.charAt(j);
                        }
                    }
                }

        } catch (FileNotFoundException var24) {
            out.println(ERROR_NOTFOUND);
            var24.printStackTrace();
        } catch (IOException var25) {
            out.println(ERROR_CANNOT_FOUND);
            var25.printStackTrace();
        } catch (Exception var26) {
            out.println(ERROR_PARSE);
            var26.printStackTrace();
        }

        return fileMatrix;
    }

    public void printMatrix(String title, char[][] matrix) {
        int cont = 0;
        out.println(title + "\n");
        int colum =  columList.get(cont);
        out.println("Matriz do aquivo " + title + "\n");

        for (char[] matrixTemp : matrix) {
            StringBuilder presentantionSB = new StringBuilder("|");

            for (int j = 0; j < colum; ++j) {
                presentantionSB.append(matrixTemp[j]);
                presentantionSB.append('|');
            }

            presentantionSB.append("\n");
            out.print(presentantionSB.toString());
        }

        out.println();
    }

    public char[][] cloneMatrix(char[][] matrix) {
        int cont = 0;
        int colum;
        colum = columList.get(cont);
        char[][] auxMatrix = new char[matrix.length][colum];

        for(int i = 0; i < matrix.length; ++i) {
            System.arraycopy(matrix[i], 0, auxMatrix[i], 0, colum);

            ++cont;
        }

        return auxMatrix;
    }

    public char[][] alterMatrixValue(char[][] matrix, char oldValue, char newValue) {
        int cont = 0;
        int coluna = columList.get(cont);

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < coluna; ++j) {
                if(matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }

            ++cont;
        }

        return matrix;
    }
}
