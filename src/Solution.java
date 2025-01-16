import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    private static String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();
        return result;
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        //루트->왼쪽서브트리->오른쪽서브트리 순으로 재귀호출하여 결과를 이어붙인다.
        return nodes[idx] + " " +
                preorder(nodes, 2 * idx + 1) +
                preorder(nodes, 2 * idx + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        //왼쪽 서브트리 -> 루트 노드 -> 오른쪽 서브트리 순을 재귀 호출하여 결과를 이어 붙임
        return inorder(nodes, 2 * idx + 1) +
                nodes[idx] + " " +
                inorder(nodes, 2 * idx + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        //왼쪽 서브 트리 -> 오른쪽 서브 트리 -> 루트 노드 순으로 재귀 호출하여 결과를 이어 붙임
        return postorder(nodes, 2 * idx + 1) +
                postorder(nodes,2*idx+2)+
                nodes[idx] + " ";
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution(nodes)[0]);
        System.out.println(solution(nodes)[1]);
        System.out.println(solution(nodes)[2]);
    }


}