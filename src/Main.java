import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 10,20,10,30,20,50
        //String[] -> Stream<String> -> IntStream or Stream<Integer> -> int[]
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N]; //dp[i]: a[i]로 끝나는 LIS길이. 최장증가부분수열
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }


}
