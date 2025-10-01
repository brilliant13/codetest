import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, count;
    static boolean[] col; //열 사용 여부
    static boolean[] d1; // diagonal1. ↙↗ 대각선 (r+c)
    static boolean[] d2; // diagonal2. ↘↖ 대각선 (r-c+N-1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        d1 = new boolean[2 * N - 1];
        d2 = new boolean[2 * N - 1];
        dfs(0);
        System.out.print(count);
    }

    static void dfs(int r) {
        if (r == N) {
            count++;
            return;
        }
        for (int c = 0; c < N; c++) {
            int a = r + c, b = r - c + (N - 1);
            if (col[c] || d1[a] || d2[b]) continue;
            col[c] = d1[a] = d2[b] = true;
            dfs(r + 1);
            col[c] = d1[a] = d2[b] = false;
        }

    }


}
