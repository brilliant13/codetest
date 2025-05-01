import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열 원소 개수 입력
        int n = Integer.parseInt(br.readLine());
        // 1 <=   <= n 원소 입력
        int max = 1; //뽑힌 수열의 최댓값 +1
        int target =0;
        Stack<Integer> stack = new Stack<>(); //스택 자료구조
        StringBuilder sb = new StringBuilder();
        boolean isPossible = true; // 수열 생성 가능 여부


        for (int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            if (target >= max) {
                //타겟이 현재 max보다 큰 경우
                for (int j = max; j <= target; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                max = target+1;
                stack.pop();
                sb.append("-\n");
            } else {
                //타겟이 현재 max보다 작은 경우
                if (!stack.isEmpty() && target == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    isPossible = false;
                    break;
                }
            }

        }
        // 수열 생성 가능 여부에 따른 출력
        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}

