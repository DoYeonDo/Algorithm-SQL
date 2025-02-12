import java.util.*;

class Solution {
    static class Node{
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        Node(int value, int x, int y, Node left, Node right){
            this.value = value;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    
    static int[][] result;
    static int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int idx = 0; idx < nodeinfo.length; idx++)
            nodes[idx] = new Node(idx+1, nodeinfo[idx][0], nodeinfo[idx][1], null, null);
        
        Arrays.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2){
                if(node1.y == node2.y){
                    return node1.x - node2.x;
                }
                return node2.y - node1.y;
            }
        });
        
        Node root = nodes[0];
        
        for(int idx = 1; idx < nodes.length; idx++){
            makeTree(root, nodes[idx]);
        }
        
        result = new int[2][nodeinfo.length];
        
        preOrder(root);
        idx = 0;
        postOrder(root);
        
        return result;
    }
    
    static void makeTree(Node parent, Node child){
        if(parent.x < child.x){
            if(parent.right==null)
                parent.right = child;
            else
                makeTree(parent.right, child);
        }
        else{
            if(parent.left==null)
                parent.left = child;
            else
                makeTree(parent.left, child);
        }
    }
    
    static void preOrder(Node node){
        if(node != null){
            result[0][idx++] = node.value;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    static void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            result[1][idx++] = node.value;
        }
    }
}