package com.senac.br.core.entity;

/**
 * Created by pvmeira on 02/05/17.
 */
public class MatrixCustom {
    private int columns;
    private int lines;
    private int[][] data;

    public MatrixCustom(int i, int j) {
        this.columns = j;
        this.lines = i;
        this.data = new int[i][j];
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
}
