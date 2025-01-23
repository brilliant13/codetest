import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_PriorityQueue {



    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(1);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq);

    }


}