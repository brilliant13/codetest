import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long count;
    static int MASK; //하위 N비트 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MASK = (1<<N) -1; //하위 N비트가 전부 1
        dfs(0,0,0,0); //cols, diag1, diag2, row
        System.out.print(count);
    }

    // cols: 사용 중인 열, diag1: ↙↗ 대각(다음행에서 <<1), diag2: ↘↖ 대각(다음행에서 >>1)
    static void dfs(int cols, int diag1, int diag2, int row) {
        if (row == N) { //N행 모두 배치 완료
            count++;
            return;
        }

        int available = ~(cols | diag1 | diag2) & MASK; //이번 행에서 가능한 자리들

        while (available != 0) {
            int p = available & -available; //최하위 1비트만 선택
            available -= p; //해당 자리 제거

            dfs(cols | p, (diag1 | p) << 1 & MASK, (diag2 | p) >> 1, row + 1);
            // & MASK: 왼쪽 시프트 후 상위 비트 잘라내기 (안전)
        }
    }
}
