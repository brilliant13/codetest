import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람
//        int count = 0;
        String s = "";
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>(); //결과를 저장할 리스트

        // 듣도 못한 사람
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            map.put(s, 1);
        }
        // 보도 못한 사람
        for (int j = 0; j < M; j++) {
            s = br.readLine();
            if (map.containsKey(s)) {
//                count++;
//                sb.append(s).append("\n");
                result.add(s);
            }
        }

        //결과 리스트를 사전순으로 정렬
        Collections.sort(result);

        sb.append(result.size()).append("\n"); //듣보잡 수. Collection객체의 size() 메소드 활용. ArrayList의 크기반환
        for (String name : result) {
            sb.append(name).append('\n'); //듣보잡 명단
        }
        System.out.print(sb);

    }
}
