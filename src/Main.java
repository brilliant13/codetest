import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int[] stack;
    public static int size = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    bw.write(pop() + "\n");
                    break;

                case "size":
                    bw.write(size()+"\n");
                    break;

                case "empty":
                    bw.write(String.valueOf(empty()));
                    bw.append('\n');
                    break;

                case "top":
                    bw.write(String.valueOf(top()));
                    bw.append('\n');
                    break;
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }

}
