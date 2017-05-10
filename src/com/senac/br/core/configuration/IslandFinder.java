package com.senac.br.core.configuration;

import com.senac.br.core.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pvmeira on 24/04/17.
 */
@SuppressWarnings(value = "all")
public class IslandFinder {
    private List<String> positions = new ArrayList<>();

    /**
     * Return the Total of islands that are present
     * in the matrix
     *
     * @return
     */
    public int countIslands(int[][] originalMatrix, int[][] copyMatrix) {
        int counter = 0;
        //Begin the interation of the given matrix
        for (int y = 0; y < originalMatrix.length; y++) {
            for (int x = 0; x < originalMatrix[0].length; x++) {
                //IF the int on the position isent a '1', ignore this position
                if (originalMatrix[y][x] != 1)
                    continue;
                //Verify if the position on right this position[x][y] is a islandand also chek if the position on top of the examined one also have a island
                // , if so, save the value on the copyMatrix
                //and by enter the if, the count dosent growl
                if (getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 0, -1) != 0) {
                    copyMatrix[y][x] = getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 0, -1);
                    if (x > 0 && getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, -1, 0) != 0) {
                        if (copyMatrix[y][x - 1] != copyMatrix[y][x])
                            counter--;
                        copyMatrix[y][x - 1] = copyMatrix[y][x];
                    }
                    //Verify if the position above this position[x][y] is a island, if so, save the value on the copyMatrix
                    //and by enter the if, the count dosent growl
                } else if (getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, -1, 0) != 0)
                    copyMatrix[y][x] = getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, -1, 0);
                    //Verify if the position on bottom this position[x][y] is a island, if so, save the value on the copyMatrix
                    //and by enter the if, the count dosent growl
                else if (getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 1, 0) != 0)
                    copyMatrix[y][x] = getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 1, 0);
                    //Verify if the position on left this position[x][y] is a island, if so, save the value on the copyMatrix
                    //and by enter the if, the count dosent growl
                else if (getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 0, 1) != 0)
                    copyMatrix[y][x] = getValueFrom1(copyMatrix, copyMatrix[0].length, copyMatrix.length, x, y, 0, 1);
                    //Else if the island is isololated, than increment the counter
                else
                    copyMatrix[y][x] = ++counter;
            }
        }

        return counter;
    }

    public void getPositionIsland(int[][] n){
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                if(verifyIsland(n[i][j])){
                    b.append("Coluna :"+(j+1)+"  ");
                    b.append("Linha  :"+(i+1)+"  ");
                    b.append("\n");
                }
            }
        }
        System.out.println(b.toString());
    }

    private boolean verifyIsland(int position){
        if(position == 1){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }

    }

    private void createTheIndexForTheMatrix(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                if (n[i][j] == 1) {
                    this.positions.add("Position [" + i + "][" + j + "]");
                }
            }
        }
    }

    public void printIndex() {

        for (int i = 0; i < positions.size(); i++) {
            String s = positions.get(i);
            System.out.println(s + "\n");
        }
    }

    /**
     * Method that return the value on the given position,
     * respecting the bounds of the given array
     *
     * @param copyMatrix
     * @param sizeX
     * @param sizeY
     * @param x
     * @param y
     * @param diffX
     * @param diffY
     * @return
     */
    private int getValueFrom1(int[][] copyMatrix, int sizeX, int sizeY, int x, int y, int diffX, int diffY) {
        x = x + diffX;
        y = y + diffY;
        //Verify if the positions x and y, dosent go outofbounds
        if (x < 0 || y < 0 || x >= sizeX || y >= sizeY)
            return 0;
        //if not, return the value of the given position
        return copyMatrix[y][x];
    }

}
