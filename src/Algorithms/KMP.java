package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    //LPS(pi) 배열 만들기: lps[i] = P[0..i]으 ㅣ최장 접두사==접미사 길이
    static int[] buildLPS(String p) {
        int n = p.length();
        int[] lps = new int[n];
        int j =0; // 현재까지 일치한 접두사 길이

        for (int i = 1; i < n; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = lps[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
                lps[i] = j;
            }
            //다르면 lps[i]는 기본 0
        }
        return lps;
    }

    //KMP 본문: s에서 p의 (겹침 허용) 모든 매칭 시작 인덱스 반환
    static List<Integer> kmp(String s, String p) {
        List<Integer> positions = new ArrayList<>();
        if(p.isEmpty()){ //빈 패턴 처리: 원한다면 0을 반환하거나 예외로 바꿔도 됨
            for (int i = 0; i <= s.length(); i++) positions.add(i);
            return positions;
        }

        int[] lps = buildLPS(p);
        int j =0; //패턴 인덱스

        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    positions.add(i-p.length()+1);
                    j = lps[j];
                }else{
                    j++;
                }
            }
        }
        return positions;
    }
    //테스트용
    public static void main(String[] args) {
        String word = "ababdababcabbababcababcababa";
        System.out.println("word.length() = " + word.length());
        String pattern = "ababcaba";
//        String pattern = "";

        List<Integer> pos = kmp(word, pattern);
        System.out.println(pos.size());
        System.out.println(pos);
    }

}
