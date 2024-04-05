package 전체문제.fifth_month_2023_04.fourth_2024_04_05;

import java.util.*;
import java.io.*;
public class BJ_5639_이진검색트리_Gold_5_Re {
    static class Node{
        int head; Node left; Node right;

        public Node(int head) {
            this.head = head;
        }

        public Node(int head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }
        void insert(int num){
            if(num<this.head){
                if(this.left==null) this.left = new Node(num);
                else this.left.insert(num);
            }else{
                if(this.right==null) this.right = new Node(num);
                else this.right.insert(num);
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
            if(input==null || input.equals("")) break;
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