import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int max =0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }

        boolean isComposite[] = make_prime(max);

        int count =0;
        for (int num : numbers) {
            if (num > 1 && !isComposite[num]) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean[] make_prime(int max) {
        boolean[] prime = new boolean[max + 1];
        if(max >= 0) prime[0] = true;
        if(max >= 1) prime[1] = true;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!prime[i]) { //소수라면, 그것의 배수는 합성수처리한다. 합성수는 소수의 반대.
                for (int j = i * i; j < max + 1; j += i) {
                    prime[j] = true;
                }
            }
        }
        return prime;
    }
}