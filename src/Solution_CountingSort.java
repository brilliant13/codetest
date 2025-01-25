import java.util.ArrayList;
import java.util.Arrays;

public class Solution_CountingSort {

    private static String solution(String s) {
        //알파벳 개수(26개)만큼 빈도수 배열 생성
        int[] counts = new int[26];

        //문자열의 각 문제에 대한 빈도수를 count 배열에 저장
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }

        //빈도수 배열을 순회하면서 정렬된 문자열을 생성
        StringBuilder sortedStr = new StringBuilder();//문자열을 더하거나 수정할 때 효율적으로 동작하는 클래스
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