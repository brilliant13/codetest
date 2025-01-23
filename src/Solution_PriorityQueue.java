import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_PriorityQueue {



    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<String> pq = new PriorityQueue<>
                (Comparator.comparingInt(o -> o.charAt(1)));

        pq.add("90");
        pq.add("91");
        pq.add("92");
        pq.add("93");

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq);

    }


}