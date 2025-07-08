import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class My_BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //initialize graph here

        //노드 4개 그래프 초기화
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        //간선 추가 (0-1, 0-2, 1-3)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(3).add(1);

        bfs(0,graph);
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
