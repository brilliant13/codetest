import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int count = 0;
        int ioi = 0;
        // "OOIOIOIOIIOII"
        // 문자열 길이만큼 선형 탐색 O(M)
        for (int i = 0; i + 2 < M; ) {
            //"IOI"
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
//                System.out.println("i = " + i);
                ioi++;
                if (ioi >= N) { //IOIIOIIOIOOO N이 1, ioi가 3이면 count가 계속 올라가야함
                    count++;
                }
                i += 2;
            } else {
                //패턴깨지면 초기화
                ioi = 0;
                i++;
            }
        }
        System.out.println(count);
    }
}
