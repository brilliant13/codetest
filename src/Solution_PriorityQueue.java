import java.util.*;

public class Solution_PriorityQueue {



    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(1);

//        System.out.println(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>(list);

        System.out.println(pq);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq);

        pq.addAll(list);

        System.out.println(pq);


    }


}