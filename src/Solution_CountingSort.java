import java.util.ArrayList;
import java.util.Arrays;

public class Solution_CountingSort {

    private static String solution(String s) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char) (i + 'a'));
            }
        }
        return sortedStr.toString();
    }




    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution("algorithm"));

    }


}