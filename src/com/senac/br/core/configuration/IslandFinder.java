package com.senac.br.core.configuration;

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
                if (getValueFrom(n, n.length, x, y, -1, 0) != 0)
                    n[y][x] = getValueFrom(n, n.length, x, y, -1, 0);

                else if (getValueFrom(n, n.length, x, y, -1, 0) != 0)
                    n[y][x] = getValueFrom(n, n.length, x, y, 1, 0);

                else if (getValueFrom(n, n.length, x, y, 0, -1) != 0)
                    n[y][x] = getValueFrom(n, n.length, x, y, 0, -1);

                else if (getValueFrom(n, n.length, x, y, 0, 1) != 0)
                    n[y][x] = getValueFrom(n, n.length, x, y, 0, 1);

                else
                    n[y][x] = ++counter;
            }
        }
        return counter;
    }
//    /**
//     * // TODO: 24/04/17   Esta logica está correta, falta apenas transformar em generica
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        int[][] m = {{1, 0, 1, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}};
//        int[][] n = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
//        int counter = 0;
//        for (int y = 0; y < m.length; y++) {
//            for (int x = 0; x < m[0].length; x++) {
//                if (m[y][x] != 1)
//                    continue;
//                if (getValueFrom(n, n.length, x, y, -1, 0) != 0)
//                    n[y][x] = getValueFrom(n, n.length, x, y, -1, 0);
//
//                else if (getValueFrom(n, n.length, x, y, -1, 0) != 0)
//                    n[y][x] = getValueFrom(n, n.length, x, y, 1, 0);
//
//                else if (getValueFrom(n, n.length, x, y, 0, -1) != 0)
//                    n[y][x] = getValueFrom(n, n.length, x, y, 0, -1);
//
//                else if (getValueFrom(n, n.length, x, y, 0, 1) != 0)
//                    n[y][x] = getValueFrom(n, n.length, x, y, 0, 1);
//
//                else
//                    n[y][x] = ++counter;
//            }
//        }
//        System.out.println("counter: " + counter);
//    }

    private static int getValueFrom(int[][] m, int size, int x, int y, int diffX, int diffY) {
        x = x + diffX;
        y = y + diffY;
        if (x < 0 || y < 0 || x >= size || y >= size)
            return 0;
        return m[y][x];
    }

}
