import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_dijkstra {
    //노드의 정보(노드 번호와 거리)를 쌍으로 저장할 클래스 생성
    private static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int[] solution(int[][] graph, int start, int n) {
        //인접 리스트를 저장할 ArrayList 배열 초기화
        ArrayList<Node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        //graph 정보를 인접 리스트로 저장
        for (int[] edge : graph) {
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.dest]<now.cost)
                continue;
            for (Node next : adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest]=now.cost+next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

    return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        System.out.println(Arrays.toString(solution(graph, 0, 3)));
        int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
        System.out.println(Arrays.toString(solution(graph2, 0, 4)));

    }


}