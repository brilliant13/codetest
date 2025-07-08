import java.util.ArrayList;
import java.util.Stack;

public class My_WeightedDFS {
    static ArrayList<int[]>[] adj; // [목적지, 가중치] 형태로 저장
    static boolean[] visited;

//    public static void dfs(int v) {
//        visited[v] = true;
//        System.out.println(v + " -> ");
//
//        for (int[] edge : adj[v]) {
//            int neighbor = edge[0]; // 목적지 노드
//            int weight = edge[1]; // 가중치
//            System.out.println("(가중치 " + weight + ") ");
//
//            if (!visited[neighbor]) {
//                dfs(neighbor);
//            }
//        }
//    }
// Stack을 활용한 반복적 DFS
public static void dfs(int v) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);
    visited[v] = true;

    while (!stack.isEmpty()) {
        int vertex = stack.pop();
        System.out.print(vertex + " -> ");

        // 현재 노드의 모든 인접 노드 확인
        for (int[] edge : adj[vertex]) {
            int neighbor = edge[0];  // 목적지 노드
            int weight = edge[1];    // 가중치

            System.out.print("(w:" + weight + " to " + neighbor + ") ");

            if (!visited[neighbor]) {
                stack.push(neighbor);
                visited[neighbor] = true;
            }
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        int n = 5;
        adj = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        addEdge(0, 1, 5); // 0 ->1 (가중치 5)
        addEdge(0, 2, 3); // 0 ->1 (가중치 5)
        addEdge(1, 2, 2); // 0 ->1 (가중치 5)
        addEdge(2, 3, 7); // 0 ->1 (가중치 5)
        addEdge(3, 4, 1); // 0 ->1 (가중치 5)

        System.out.println("=== Stack 기반 가중치 DFS ===");
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("Connected Component starting from " + i + ":");
                dfs(i);
                System.out.println();
            }
        }
    }

    private static void addEdge(int from, int to, int weight) {
        adj[from].add(new int[]{to, weight});
    }
}
