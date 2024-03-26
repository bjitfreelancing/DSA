package javacode;

import java.util.Arrays;

public class Matrix {
  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void sortMatrixRow(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      Arrays.sort(matrix[i]);
    }
  }

  public static boolean searchSortedMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int row = 0;
    int col = cols - 1;

    while (row < rows && col >= 0) {
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        row++;
      } else col--;
    }
    return false;
  }
  public static void main(String[] args) {
    int[][] matrix = {
        {3,2,1,4},
        {6,5,8,7},
        {9,10,12,11}
    };
    System.out.println("Original matrix: ");
    printMatrix(matrix);
    sortMatrixRow(matrix);

    System.out.println("\nSorted Matrix (each row):");
    printMatrix(matrix);

    int target = 6;
    boolean found = searchSortedMatrix(matrix, target);
    System.out.println("Element: " + target + " found: " + found);
  }
}
