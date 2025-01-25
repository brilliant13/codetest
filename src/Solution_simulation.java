import java.util.ArrayList;
import java.util.Arrays;

public class Solution_simulation {


    private static int[][] rotate90(int[][] arr) {
        int n= arr.length;
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n-1-i]=arr[i][j];
            }
        }
    return rotatedArr;
    }

    private static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
        System.out.println(Arrays.deepToString(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));

    }


}