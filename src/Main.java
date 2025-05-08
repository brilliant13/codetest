import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0; //공집합으로 시작

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            String operation = command[0];

            switch(operation) {
                case "add":
                    //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    int x = Integer.parseInt(command[1]);
                    S |= (1<<(x-1)); //x를 추가. 인덱스 0번부터 원소1번으로 쓴다.
                    break;
                case "remove":
                    //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                    x = Integer.parseInt(command[1]);
                    S &= ~(1<<(x-1)); //x를 제거
                    break;
                case "check":
                    x = Integer.parseInt(command[1]);
                    if ((S & (1 << (x - 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    x = Integer.parseInt(command[1]);
                    S ^= (1<<(x-1)); //x 토글
                    break;
                case "all":
                    //all: S를 {1, 2, ..., 20} 으로 바꾼다.
                    S = (1<<20)-1; //모든 비트를 1로 (1~20 전체 집합) 2^n-1
                    break;
                case "empty":
                    S = 0; //모든 비트를 0으로 (공집합)
                    break;
             }
        }
        System.out.println(sb);
    }
}
