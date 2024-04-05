package 구현.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5639_이진검색트리_Gold_5 {


    static class Node{
        int head; Node left; Node right;
        public Node(int head) {this.head = head;}
        public Node(int head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n<this.head){
                if(this.left==null){
                    this.left = new Node(n);
                }else left.insert(n);
            }else{
                if(this.right==null){
                    this.right = new Node(n);
                }else right.insert(n);
            }
        }
    }
    static Node root;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true){
            input = br.readLine();
            if(input==null||input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
        System.out.println(sb.toString());
    }
    static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.head+"\n");
    }
}