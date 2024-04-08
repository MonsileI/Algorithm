package 전체문제.fifth_month_2023_04.fifth_2924_04_08;

import java.util.*;
import java.io.*;
public class BJ_5639_이진검색트리_Gold_5 {
    static class Node {
        int head; Node left; Node right;

        public Node(int head) {
            this.head = head;
        }

        public Node(int head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }

        void insert(Node node,int num){
            if(node.head > num){
                if(node.left==null) node.left = new Node(num);
                else insert(node.left,num);
            }else{
                if(node.right==null) node.right = new Node(num);
                else insert(node.right,num);
            }
        }
    }
    static Node root;
    static StringBuilder sb=  new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            input = br.readLine();
            if(input==null || input.equals("")) break;
            int num = Integer.parseInt(input);
            root.insert(root,num);
        }
        preOrder(root);
        System.out.println(sb.toString());
    }
    static void preOrder(Node node){
        if(node==null) return;
        preOrder(node.left);
        preOrder(node.right);
        sb.append(node.head+"\n");
    }

}
