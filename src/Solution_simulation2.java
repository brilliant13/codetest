import java.util.Arrays;

public class Solution_simulation2 {

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] multiplied = multiplyMatrices(matrix1, matrix2);

        return transposeMatrix(multiplied);
    }


    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {9, 8, 7},
                {6,5,4},
                {3,2,1}
        };
        System.out.println(Arrays.deepToString(solution(matrix1, matrix2)));


    }


}