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

        int[] tails = new int[N];
        int len = 0;

        for (int x : a) {
            int pos = Arrays.binarySearch(tails, 0, len, x);
            if(pos<0) pos = -(pos+1); //삽입위치 (lower_bound)
            tails[pos] = x;
            if(pos == len) len++;
        }
        System.out.println(len);
    }


}
