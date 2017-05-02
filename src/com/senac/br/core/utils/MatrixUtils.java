package com.senac.br.core.utils;

import com.senac.br.core.entity.MatrixCustom;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by pvmeira on 24/04/17.
 */
@SuppressWarnings(value = "all")
public class MatrixUtils {

    private static List<Integer> columList = new ArrayList();
    private static String ERROR_NOTFOUND = "Não encontrou o arquivo!";
    private static String ERROR_CANNOT_FOUND = "Não conseguiu ler o arquivo!";
    private static String ERROR_PARSE = "Erro de parse";
    private int lineCount;
    private int columCount;

    public MatrixUtils() {
    }

    /**
     * Create a matrix, using a file in the following pattern
     * linhas colunas
     * dados da linha 0
     * dados da linha 1
     * trows FileNotFoundException,IOException and Exception
     *
     * @param path
     * @return
     */
    public char[][] createMatrixFromTxt(String path) {
        columCount = 0;
        lineCount = 0;
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

    /**
     * Print the given matrix
     *
     * @param title
     * @param matrix
     */

    public void printMatrix(String title, char[][] matrix) {
        int cont = 0;
        out.println(title + "\n");
        int colum = columList.get(cont);
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

    /**
     * Clone the given matrix
     *
     * @param matrix
     * @return
     */
    public char[][] cloneMatrix(char[][] matrix) {
        int cont = 0;
        int colum;
        colum = columList.get(cont);
        char[][] auxMatrix = new char[matrix.length][colum];

        for (int i = 0; i < matrix.length; ++i) {
            System.arraycopy(matrix[i], 0, auxMatrix[i], 0, colum);

            ++cont;
        }

        return auxMatrix;
    }

    /**
     * Change the values present in the given matrix,
     * using the old new Values
     *
     * @param matrix
     * @param oldValue
     * @param newValue
     * @return
     */
    public char[][] alterMatrixValue(char[][] matrix, char oldValue, char newValue) {
        int cont = 0;
        int coluna = columList.get(cont);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < coluna; ++j) {
                if (matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }

            ++cont;
        }

        return matrix;
    }

    /**
     * Transform a char[][] to a int[][]
     *
     * @param m
     * @return
     */
    public int[][] transformMatrixCharInt(char[][] m) {
        int[][] result = new int[m.length][m[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int y = 0; y < result[0].length; y++) {
                result[i][y] = Character.getNumericValue(m[i][y]);
            }
        }
        return result;
    }

    /**
     * Print the the int[][] given matrix
     *
     * @param title
     * @param matrix
     */
    public void printIntMatrix(String title, int[][] matrix) {
        int cont = 0;
        out.println(title + "\n");
        int colum = matrix[0].length;
        out.println("Matriz do aquivo " + title + "\n");

        for (int[] matrixTemp : matrix) {
            StringBuilder presentantionSB = new StringBuilder("|");

            for (int j = 0; j < colum; ++j) {
                presentantionSB.append(matrixTemp[j]);
                presentantionSB.append('|');
            }

            presentantionSB.append("\n");
            out.print(presentantionSB.toString());
            cont++;
        }

        out.println();
    }

    public char[][] createNewMatrixFill0(char[][] meh) {
        int rows = meh.length;
        int cols = meh[0].length;
        char[][] meh2 = new char[rows][cols];

        for (char[] chars : meh2) {
            Arrays.fill(chars, '0');
        }
        return meh2;

    }

    /**
     * From this point, all the code is a example from https://github.com/rafasgj/Algoritmos3
     * with a alternative solution to operations with a file.txt matrix
     * @return
     */
    public static MatrixCustom loadFromFile(String filename) throws FileNotFoundException {
        try(Scanner file = new Scanner(new FileReader(filename))) {
            int colums = file.nextInt();
            int lines = file.nextInt();
            MatrixCustom result = new MatrixCustom(lines, colums);
            file.nextLine(); // a '\n' is left behind.
            for (int i = 0; i < result.getLines(); i++) {
                char[] line = file.nextLine().toCharArray();
                for (int j = 0; j < result.getColumns(); j++) {
                    result.getData()[i][j] = line[j] - '0';
                }
            }
            return result;
        }
    }

    public MatrixCustom findAndReplace(MatrixCustom matrix,int a, int b) {
        for (int i = 0; i < matrix.getLines(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                int v = matrix.getData()[i][j];
                matrix.getData()[i][j] = (v == a) ? b : v;
            }
        }
        return matrix;
    }

    public void printTo(PrintStream out,MatrixCustom result) {
        for (int i = 0; i < result.getLines(); i++) {
            out.print("|");
            for (int j = 0; j < result.getColumns(); j++) {
                out.print(result.getData()[i][j] + "|");
            }
            out.println();
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getColumCount() {
        return columCount;
    }

    public void setColumCount(int columCount) {
        this.columCount = columCount;
    }


}
