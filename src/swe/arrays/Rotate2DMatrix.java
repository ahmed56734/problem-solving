package swe.arrays;

public class Rotate2DMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(arr);
    }

    public static int[][] rotate(int[][] matrix) {
        printMatrix(matrix);
        transposeMatrix(matrix);
        printMatrix(matrix);
        flipHorizontally(matrix);
        printMatrix(matrix);
        return matrix;
    }

    private static void transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                //swap i,j with j,i
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    private static void flipHorizontally(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, rowLength = matrix[i].length; j < rowLength / 2; j++) {
                int leftItem = matrix[i][j];
                int oppositeItem = matrix[i][rowLength - 1 - j];
                //swap
                matrix[i][j] = oppositeItem;
                matrix[i][rowLength - 1 - j] = leftItem;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                System.out.print(value + ", ");
                if (j == matrix[0].length - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}
