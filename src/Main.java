import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        //C가 최소
        if(A>=C && B>=C) {
            sb.append(0).append(" ").append(C);
        }
        //C가 중간
        else if(A>B && C>B || B>C && C>A){
            sb.append(0).append(" ").append(C-Math.max(A,B)).append(" ").append(Math.min(A,B)).append(" ").append(Math.max(A,B));
        }


    }




}
