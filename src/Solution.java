import java.util.ArrayDeque;

public class Solution {
    public static int solution(int N, int K){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        int n = solution(5,3);
        System.out.println(n);

    }



}