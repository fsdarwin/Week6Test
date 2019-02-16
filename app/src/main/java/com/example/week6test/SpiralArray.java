package com.example.week6test;

public class SpiralArray {

    public static void main(String args[]) {

        int r = 4, c = 4;
        int[][] intArray = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                intArray[i][j] = i * r + j + 1;
            }
        }
        int iter, startRow = 0, startCol = 0,
                endRow = r, endCol = c;

        //startRow - starting row index
        //endRow - ending row index - r
        //startCol - starting column index
        //endCol - ending column index - c
        //iter - iterator

        while (startRow < endRow && startCol < endCol) {
            for (iter = startCol; iter < endCol; ++iter) {
                System.out.print(intArray[startRow][iter] + " ");
            }
            startRow++;
            for (iter = startRow; iter < endRow; ++iter) {
                System.out.print(intArray[iter][endCol - 1] + " ");
            }
            endCol--;
            if (startRow < endRow) {
                for (iter = endCol - 1; iter >= startCol; --iter) {
                    System.out.print(intArray[endRow - 1][iter] + " ");
                }
                endRow--;
            }
            if (startCol < endCol) {
                for (iter = endRow - 1; iter >= startRow; --iter) {
                    System.out.print(intArray[iter][startCol] + " ");
                }
                startCol++;
            }
        }

    }

}
