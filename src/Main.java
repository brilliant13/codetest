import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(N, r, c));

    }

    private static long solve(int n, int r, int c) {
        if(n==0) return 0;
        int half = 1 << (n - 1); //2^n-1;
        int quadrant = (r >= half ? 2 : 0) + (c >= half ? 1 : 0);
        long base = (long)quadrant * half * half; //이전 사분면까지 개수.
        return base + solve(n - 1, r % half, c % half); //사분면 축소, 행,열도 로컬좌표로 축소

    }
}
