package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진검색트리 {
    static class LinkedNode {
        int value;
        LinkedNode left;
        LinkedNode right;

        LinkedNode(int value) {
            this.value = value;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left == null)
                    this.left = new LinkedNode(n);
                else
                    this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new LinkedNode(n);
                else
                    this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        LinkedNode rootNode = new LinkedNode(Integer.parseInt(input));

        while ((input = br.readLine()) != null && !input.equals("")) {
            rootNode.insert(Integer.parseInt(input));
        }

        postOrder(rootNode);
    }

    private static void postOrder(LinkedNode node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
