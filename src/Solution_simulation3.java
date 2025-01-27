import java.util.Arrays;

public class Solution_simulation3 {

    private static int[][] solution(int n) {
        // n크기의 2차원 배열 생성
        int[][] snailArray = new int[n][n];
        int num =1; //달팽이 수열 시작 숫자

        int startRow =0, endRow = n-1;
        int startCol=0, endCol= n-1;

        while (startRow <= endRow && startCol <= endCol) {
            //첫 번째 행 채우기
            for (int i = startCol; i <= endCol; i++) {
                snailArray[startRow][i]=num++;
            }
            startRow++;

            //마지막 열 채우기
            for (int i = startRow; i <= endRow; i++) {
                snailArray[i][endCol]=num++;
            }
            endCol--;

            //마지막 행 채우기
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    snailArray[endRow][i]=num++;
                }
                endRow--;
            }

            //첫 번째 열 채우기
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    snailArray[i][startCol]=num++;
                }
                startCol++;
            }
        }
        return snailArray;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(solution(3)));
        System.out.println(Arrays.deepToString(solution(4)));


    }


}