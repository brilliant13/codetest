package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeTraversal {

    public Node root;

    public void init(char data, char leftData, char rightData) {
        if (this.root == null) {
            root = new Node(data);
            if (leftData != 0) {
                root.left = new Node(leftData);
            }

            if (rightData != 0) {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    private void searchNode(Node node, char data, char leftData, char rightData) {
        if(node == null) return;
        if (node.data == data) {
            if (leftData != 0) {
                node.left = new Node(leftData);
            }
            if (rightData != 0) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node) { //루트-왼쪽트리-오른쪽트리
        if (node != null) {
            System.out.print(node.data);
            System.out.print(' ');
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) { //왼쪽트리-루트-오른쪽트리
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            System.out.print(' ');
            inOrder(node.right);

        }

    }

    public void postOrder(Node node) { //왼쪽트리-오른쪽트리-루트
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
            System.out.print(' ');

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeTraversal tree = new TreeTraversal();
        char[] data;
        for (int i = 0; i < n; i++) {
            data = br.readLine().toCharArray();
            tree.init(data[0], data[1], data[2]);
        }
        br.close();

        System.out.print("전위 순회 : ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.print("중위 순회 : ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.print("후위 순회 : ");
        tree.postOrder(tree.root);
    }

}

class Node{
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}
