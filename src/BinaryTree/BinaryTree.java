package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    static class BTree{
        static int index = -1;

        public static Node buildTree(int[] nodes){
            index++;
            if (nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static void levelOrder(Node root){
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            Node currentNode = queue.remove();

            if (currentNode == null){
                System.out.println();

                if (queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
            else{

                System.out.print(currentNode.val + " ");

                if (currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BTree.buildTree(nodes);
        levelOrder(root);
    }
}
