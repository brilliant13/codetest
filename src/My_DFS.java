import java.util.*;

public class My_DFS {
  /*
  1.알고리즘은 임의의 정점에서 시작하여 방문한 것으로 표시하고 스택에 푸시한다
  2. 스택에서 맨 위 정점을 가져온다.
  3. 방문하지 않은 모든 인접 정점을 방문한 것으로 표시하고 스택으로 푸시한다.
  4. 스택이 비워질 때까지 프로세스를 반복한다.
  */


    static ArrayList<Integer>[] adj; //adjaceny list representation of the graph
    static boolean[] visited; // array to keep track of visitied vertices

    //반복구현 (Stack 활용)
   /* public static void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + "->");

            for (int neighbor : adj[vertex]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor]=true;
                }
            }
        }
    }*/

    //재귀활용
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " -> ");

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // number of vertices. 0~4 vertex
        adj = new ArrayList[n];
        visited = new boolean[n];

        //인접리스트 초기화, 방문배열 초기화
        // initialize adjacency list and visited array
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
        }

        //add edges to the graph
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(2);
        adj[2].add(0);
        adj[2].add(3);
        adj[3].add(3);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }
}
