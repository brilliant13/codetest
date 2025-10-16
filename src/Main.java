import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    //KMP: LPS
    static int[] buildLPS(String p) {
        int n = p.length();
        int[] lps = new int[n]; // 0..n-1

        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                j = lps[j - 1];
            }
            if (p.charAt(j) == p.charAt(i)) {
                j++;
                lps[i] = j;
            }
        }
        return lps;
    }

    //KMP : 모든 매칭 시작 인덱스
    static List<Integer> kmp(String s, String p) {
        int pattern = p.length();
        List<Integer> pos = new ArrayList<>();

        if (p.isEmpty()) {
            for (int i = 0; i <= s.length(); i++) {
                pos.add(i);//빈 문자열 매칭
            }
        }


        int[] lps = buildLPS(p);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == pattern - 1) {
                    pos.add(i - (pattern - 1)); //  i - (pattern -1)   ~ i 까지가 pattern 길이.
                    j = lps[j]; //겹침허용. 패턴다채우고도 Preffix, Suffix 같은 부분있으면 그 다음부분부터 비교하도록 Jump
                } else {
                    j++;
                }
            }
        }
        System.out.println(pos.size());
        for (int po : pos) {
            System.out.print(po+ " ");
        }
        System.out.println();
        return pos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String A = br.readLine();
        String B = br.readLine();

        int n = S.length();
        int aLen = A.length();
        int bLen = B.length();

        if (aLen > n || bLen > n) {
            System.out.println(0);
            return;
        }

        //1) A 시작 위치들, B 끝 위치들
        System.out.println("============== kmp(S,A) 차례");

        boolean[] startA = new boolean[n]; //0..n-1
        for (int i : kmp(S, A)) { //A가 S에 나타나는 시작 위치 인덱스 List로 반환해준다.
            startA[i] = true;
            System.out.println("A의 시작 위치들 i = " + i);
        }
        System.out.println("============== kmp(S,B) 차례");
        boolean[] endB = new boolean[n]; //0..n-1
        for (int i : kmp(S, B)) { //B가 S에 나타나는 시작 위치 인덱스 List로 반환해준다.
            //그럼 End 인덱스는 시작 위치 인덱스 + (패턴의 길이 -1)
            int end = i + bLen - 1;
            if (end < n) {
                endB[end] = true;
                System.out.println("B의 끝 위치들 end = " + end);
            }
        }

        //2) 서로 다른 부분문자열 수집

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if(!startA[i]) continue;
            for (int j = i; j < n; j++) {
                if(!endB[j]) continue;
                if(j >= i + Math.max(aLen, bLen) - 1){
                    set.add(S.substring(i, j + 1));
                }
            }
        }

        System.out.print(set.size());




    }
}
