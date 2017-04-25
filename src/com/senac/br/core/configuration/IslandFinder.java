package com.senac.br.core.configuration;

import com.senac.br.core.utils.MatrixUtils;

/**
 * Created by pvmeira on 24/04/17.
 */
@SuppressWarnings(value = "all")
public class IslandFinder {

    /**
     * Return the Total of islands that are present
     * in the matrix
     *
     * @return
     */
    public int countIslands(int[][] m, int[][] n) {
        int counter = 0;
        for (int y = 0; y < m.length; y++) {
            for (int x = 0; x < m[0].length; x++) {
                if (m[y][x] != 1)
                    continue;
                if (getValueFrom1(n, n[0].length, n.length, x, y, 0, -1) != 0) {
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 0, -1);
                    if (x > 0 && getValueFrom1(n, n[0].length, n.length, x, y, -1, 0) != 0) {
                        if(n[y][x - 1] != n[y][x])
                            counter--;
                        n[y][x - 1] = n[y][x];
                    }
                } else if (getValueFrom1(n, n[0].length, n.length, x, y, -1, 0) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, -1, 0);
                else if (getValueFrom1(n, n[0].length, n.length, x, y, 1, 0) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 1, 0);
                else if (getValueFrom1(n, n[0].length, n.length, x, y, 0, 1) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 0, 1);
                else
                    n[y][x] = ++counter;
            }
        }
        return counter;
    }

    private int getValueFrom(int[][] m, int size, int x, int y, int diffX, int diffY) {
        x = x + diffX;
        y = y + diffY;
        if (x < 0 || y < 0 || x >= size || y >= size)
            return 0;
        return m[y][x];
    }

    private static int getValueFrom1(int[][] m, int sizeX, int sizeY, int x, int y, int diffX, int diffY) {
        x = x + diffX;
        y = y + diffY;
        if (x < 0 || y < 0 || x >= sizeX || y >= sizeY)
            return 0;
        return m[y][x];
    }

    /**
     * // TODO: 24/04/17   Esta logica está correta, falta apenas transformar em generica
     *
     * @param args
     */
    public static void main(String[] args) {
        MatrixUtils matrixUtils = new MatrixUtils();
        int[][] m = {{0, 0, 0}, // 100
                {0, 0, 1},  // 110
                {0, 0, 1},  // 000
                {0, 1, 1},  //
                {0, 1, 0}};

        int[][] n = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        int counter = 0;
        for (int y = 0; y < m.length; y++) {
            for (int x = 0; x < m[0].length; x++) {
                if (m[y][x] != 1)
                    continue;
                if (getValueFrom1(n, n[0].length, n.length, x, y, 0, -1) != 0) {
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 0, -1);
                    if (x > 0 && getValueFrom1(n, n[0].length, n.length, x, y, -1, 0) != 0) {
                        counter--;
                        n[y][x - 1] = n[y][x];
                    }
                } else if (getValueFrom1(n, n[0].length, n.length, x, y, -1, 0) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, -1, 0);

                else if (getValueFrom1(n, n[0].length, n.length, x, y, 1, 0) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 1, 0);
                else if (getValueFrom1(n, n[0].length, n.length, x, y, 0, 1) != 0)
                    n[y][x] = getValueFrom1(n, n[0].length, n.length, x, y, 0, 1);
                else
                    n[y][x] = ++counter;
            }
        }
        System.out.println("counter: " + counter);
        matrixUtils.printIntMatrix("meh", n);
    }


}
