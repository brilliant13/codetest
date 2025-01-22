import java.util.ArrayList;
import java.util.Arrays;

public class Solution_BackTracking {
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;

    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }
        //다음에 선택할 수 있는 숫자들을 하나씩 선택하면서
        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        //Call BackTracking function
        backtrack(0, new ArrayList<>(), 1);
        return result;
    }


public static void main(String[] args) {
    System.out.println(solution(5));
    System.out.println(solution(2));
    System.out.println(solution(7));
}


}