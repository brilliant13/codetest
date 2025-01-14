import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    public static int solution(int N, int K){
        return 1;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("ABC",10);
        hashMap.put("BBB",20);
        hashMap.put("AAA",30);
        hashMap.put("ABC",15);

        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.get("ABC"));
        System.out.println(hashMap.containsKey("ABC"));

        hashMap.remove("ABC");
        System.out.println(hashMap.size());

        hashMap.clear();
        System.out.println(hashMap.isEmpty());


    }



}