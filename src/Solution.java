import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    private static boolean solution(int [] arr, int target){
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8};
        int[] arr2 = {2, 3, 5, 9};
        System.out.println(solution(arr, 6));
        System.out.println(solution(arr2, 10));

    }



}